package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value=false)
@Slf4j
public class BoardQueryMethodJPQLTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("1. 전달된 글번호보다 큰 레코드 검색")
    public void test(){
        log.info("test");
        boardRepository.findByBnoGreaterThan(150L).forEach(System.out::println);
    }

    @Test
    @DisplayName("2. 전달된 글번호, 글제목 기준")
    public void test2(){
        log.info("test2");
        boardRepository.findByBnoLessThanEqualOrTitle(150L, "제목150").forEach(System.out::println);
    }

    //////////////////////////////////////
    @Test
    @DisplayName("인수보다 큰 레코드 삭제")
    public void test3(){
        log.info("test3");
        boardRepository.delGrateByBno(150L);
    }

    @Test
    @DisplayName("글번호 or 제목으로 검색")
    public void test4(){
        log.info("test4");
        boardRepository.findByBnoOrTitle(123L, "제목111").forEach(System.out::println);
    }

    @Test
    @DisplayName("글번호, 제목, 작성자 인수로 전달 받아 검색")
    public void test5(){
        log.info("test5");
        Board board = Board.builder().bno(123L).title("제목160").writer("작성자111").build();
        boardRepository.findByWhere(board).forEach(System.out::println);
    }
}
