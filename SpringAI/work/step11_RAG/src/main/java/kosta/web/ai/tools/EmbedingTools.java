package kosta.web.ai.tools;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmbedingTools {
    private final VectorStore vectorStore;
    private final JdbcClient jdbcClient;

    public EmbedingTools(VectorStore vectorStore, JdbcClient jdbcClient) {
        this.vectorStore = vectorStore;
        this.jdbcClient = jdbcClient;
    }

    @Tool(description = "Text 파일의 내용을 읽어서 시험 문제를 PGVector 에 임베딩 합니다.")
    public String embedQuizContent(@ToolParam(description = "시험문제 Text 파일 경로") String txtFilePath) {

        String returnMessage = "";
        System.out.println("문제 임베딩 START ....." + txtFilePath);

        // # 1.단계 : 문서로드(Load Documents) - TextReader 사용
        // 별도의 복잡한 Config 없이 Resource(textResource)만 주입하면 됩니다.
        TextReader textReader = new TextReader("file:" + txtFilePath);

        // 기본적으로 UTF-8로 읽지만, 필요 시 인코딩을 명시할 수 있습니다.
        // textReader.setCharset(StandardCharsets.UTF_8);

        List<Document> documents = textReader.get();

        // # 2.단계 : 문서분할(Split Documents)
        // 텍스트 파일은 전체가 하나의 Document로 읽히므로 1000자 단위로 자르는 과정이 반드시 필요합니다.
        //            TokenTextSplitter splitter = new TokenTextSplitter(
        //                    1000, // defaultChunkSize: 청크당 최대 토큰 수
        //                    400,  // minChunkSizeChars: 최소 청크 문자 수
        //                    10,   // minChunkLengthToSplit: 분할을 위한 최소 길이
        //                    5000, // maxNumChunks: 생성할 최대 청크 수
        //                    true  // keepSeparator: 구분자 유지 여부
        //            );

        TokenTextSplitter splitter = new TokenTextSplitter(); // 기본 생성자를 사용하면 버전 변화에도 안전합니다.
        List<Document> splitDocuments = splitter.apply(documents);

        System.out.println("분할된 문서 개수: " + splitDocuments.size());
        if (!splitDocuments.isEmpty()) {
            System.out.println("첫 번째 분할 문서 샘플: " + splitDocuments.get(0).getText());
        }

        // # 3.단계 : 임베딩 -> 4.단계 : DB에 저장(백터스토어 생성)
        // pgvector에 데이터가 저장되며, 설정된 임베딩 모델(OpenAI 등)을 거칩니다.
        vectorStore.accept(splitDocuments);

        System.out.println("문제 임베딩 END .....");
        return returnMessage;
    }
}
