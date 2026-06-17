package kosta.web.ai.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class RagChatController {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public RagChatController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder.build();
        this.vectorStore = vectorStore;
    }
    @GetMapping("/ragchat")
    String ragchat(String subject, String tone, String message, HttpSession httpSession) {
      // # 1.단계 : 관련 지식 검색 (Similarity Search)
        // 사용자가 입력한 주제와 유사한 문서 조각을 PGVector에서 5개 가져옵니다.
        List<Document> similarDocuments = vectorStore.similaritySearch(
                SearchRequest
                        .builder()
                        .query(subject)
                        .topK(5)
                        .build());

        // # 2.단계 : 검색된 내용을 하나의 컨텍스트로 결합(임베딩된 언어를 자연어로 변환)
        String context = similarDocuments.stream()
                .map(doc -> {
                    // 메타데이터에서 출처(파일명 등)를 가져옵니다.
                    String source = (String) doc.getMetadata().getOrDefault("source", "Unknown Source");
                    return String.format("[출처: %s]\n내용: %s", source, doc.getText());
                })
                .collect(Collectors.joining("\n"));

        System.out.println("***************");
        System.out.println("context: " + context);
        System.out.println("***************");


        // # 3.단계 : 프롬프트 작성 및 LLM 호출 (Augmentation & Generation)
        return chatClient.prompt()
                .system("""
                    당신은 JAVA 전문 출제 위원입니다.
                    제공된 [컨텍스트] 내용을 바탕으로 실제 기출문제와 유사한 객관식 문제를 생성하세요.
                    반드시 아래 규칙을 지키세요:
                    1. 각 문제는 객관식(4지 선다형)으로 구성할 것.
                    """)
                .user(String.format("""
                    주제: %s
                    [컨텍스트]
                    %s
                    [추가 요청 사항]
                    %s
                    """, subject, context, message)) //context: 증강시킨 메세지
                .call()
                .content();
    }
}
