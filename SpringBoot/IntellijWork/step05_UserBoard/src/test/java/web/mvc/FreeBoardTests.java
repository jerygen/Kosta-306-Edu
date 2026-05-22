package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.mvc.domain.FreeBoard;
import web.mvc.repository.FreeBoardRepository;

@SpringBootTest
@Slf4j
public class FreeBoardTests {
    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Test
    void test2()
    {
        for(int i=1;i<=5;i++){
            freeBoardRepository.save(FreeBoard.builder()
                                        .subject("제목"+i).writer("작성자"+i).content("내용"+i).password("1234")
                                        .build());
        }
    }

}
