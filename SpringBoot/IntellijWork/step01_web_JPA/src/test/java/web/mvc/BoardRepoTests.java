package web.mvc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;

/**
 *  @DataJpaTest는
 *  기본적으로 내장 DB(H2설정)를 자동 설정해서 테스트를 수행한다.
 *      @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 설정해서
 *      ~.properties설정을 변경하지 않고 설정에 있는 DB사용하겠다.
 *
 *  기본 trasnaction이 설정되어 있고 rollback처리된다.
 * */


//@SpringBootTest //통합테스트
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //.properties 기준으로 db 사용
@Rollback(value=false)
@Slf4j
public class BoardRepoTests {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void test() {
        log.info("board test...");
        log.info("boardRepo="+boardRepo);
    }

    /**
     * 등록
     * */
    @DisplayName("게시물 등록")
    @Test
    public void test1() {
        boardRepo.save(Board.builder()
                            .title("제목").writer("이효리").content("오늘은 수요일")
                            .build());

        boardRepo.save(Board.builder()
                .title("쉬고싶다").writer("이상순").content("쉽시다.")
                .build());

        log.info("end ................");
    }

    /**
     * 검색
     * */
    @DisplayName("게시물 검색")
    @Test
    public void test2() {
        boardRepo.findAll().forEach(board -> {
            log.info("board="+board);
        });
    }

    

}
