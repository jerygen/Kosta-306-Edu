package kosta.web.ai.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import java.util.List;

@Configuration
public class DataLoader {
    @Value("file:C:\\Edu\\SpringAI\\work\\step11_RAG\\quiz\\past-exam-questions.txt") // 기출문제 경로
    private Resource textResource;

    private final VectorStore vectorStore;
    private final JdbcClient jdbcClient;

    public DataLoader(VectorStore vectorStore, JdbcClient jdbcClient) {
        this.vectorStore = vectorStore;
        this.jdbcClient = jdbcClient;
    }

    @PostConstruct //서버가 시작되고 생성과 주입이 끝나면 이 메서드에서 일하라는 의미
    public void init(){
        Integer count=jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class)
                .single();
        System.out.println("현재 PGVector 레코드 건수 = " + count);
        if(count==0){ //처음에 딱 한 번만 하도록
            System.out.println("기출문제 임베딩 START .....");

            // # 1.단계 : 문서로드(Load Documents) - TextReader 사용
            // 별도의 복잡한 Config 없이 Resource(textResource)만 주입하면 됩니다.
            TextReader textReader = new TextReader(textResource);

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

            // 기본 생성자를 사용하면 버전 변화에도 안전합니다.
            TokenTextSplitter splitter = new TokenTextSplitter();

            List<Document> splitDocuments = splitter.apply(documents);
            System.out.println("분할된 문서 개수: " + splitDocuments.size());
            if (!splitDocuments.isEmpty()) {
                System.out.println("첫 번째 분할 문서 샘플getText: " + splitDocuments.get(0).getText());
                System.out.println("************************");
                System.out.println("첫 번째 분할 문서 샘플getMetadata: " + splitDocuments.get(0).getMetadata());
            }

            // # 3.단계 : 임베딩 -> 4.단계 : DB에 저장(백터스토어 생성)
            // pgvector에 데이터가 저장되며, 설정된 임베딩 모델(OpenAI 등)을 거칩니다.
            vectorStore.accept(splitDocuments);
            System.out.println("기출문제 임베딩 END .....");
        }
    }
}