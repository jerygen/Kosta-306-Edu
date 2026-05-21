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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;
import web.mvc.service.BoardService;

/**
 *  @DataJpaTest는
 *  기본적으로 내장 DB(H2설정)를 자동 설정해서 테스트를 수행한다.
 *      @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 설정해서
 *      ~.properties설정을 변경하지 않고 설정에 있는 DB사용하겠다.
 *
 *  기본 transaction이 설정되어 있고 rollback처리된다.
 * */


//@SpringBootTest //통합테스트
// DB 테스트(단위 테스트, 영속성) - 단위 테스트는 일반적으로 실제 DB(MySQL)보다는 테스트용(H2)으로 한다.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //.properties 기준으로 db 사용
@Rollback(value=false)
@Slf4j
public class BoardRepoTests {

    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private BoardService boardService;

    @Test
    public void test() {
        log.info("board test...");
        log.info("boardRepo="+boardRepo);
        log.info("boardService="+boardService);
    }

    /**
     * 등록
     * */
    @DisplayName("게시물 등록")
    @Test
    public void test1() {
        /*boardRepo.save(Board.builder()
                            .title("제목").writer("이효리").content("오늘은 수요일")
                            .build());

        boardRepo.save(Board.builder()
                .title("쉬고싶다").writer("이상순").content("쉽시다.")
                .build());*/

        //한번에 여러 개의 데이터를 등록
        /*for(int i=1;i<=200;i++) {
            boardRepo.save(Board.builder()
                    .title("제목"+i).writer("작성자"+i).content("내용"+i)
                    .build());
        }*/

        /////////////////////////
        /*boardRepo.save(Board.builder()
                .bno(1L)
                .title("제목").writer("작성자").content("내용")
                .build());*/

        boardRepo.save(Board.builder()
                .bno(210L)
                .title("제목").writer("작성자").content("내용")
                .build());

        log.info("end ................"); //@GeneratedValue(strategy = GenerationType.AUTO) 여기에 따라 쓰기지연 여부가 달라짐
        
    }

    /**
     * 전체 검색
     * */
    @DisplayName("전체 검색")
    @Test
    public void test2() {
        log.info("findAll test...");
        boardRepo.findAll().forEach(board -> log.info("board="+board));
    }

    /**
     * pk를 대상으로 검색
     * */
    @DisplayName("PK 검색")
    @Test
    public void test3() {
        log.info("findById test...");
        //Optional 리턴 - 대상의 존재여부
        //Board board = boardRepo.findById(100L).orElse(null);

        //찾는 객체가 없으면 예외를 발생시키므로 orElseThrow 사용
        Board board = boardRepo.findById(100L).orElseThrow(()->new RuntimeException("100번 글이 존재하지 않습니다."));
        log.info("board={}", board);
    }

    /**
     * PK 대상으로 수정
     * */
    @Test
    @DisplayName("PK대상 수정")
    public void test4() {
        boardRepo.findById(20L).ifPresent(board -> {
            board.setTitle("제목수정");
            board.setContent("내용수정");
        });

        log.info("수정완료");
    }

    /**
     * PK를 대상으로 삭제
     * */
    @Test
    @DisplayName("PK대상 삭제")
    public void test5() {
        //boardRepo.deleteById(10L);
        boardRepo.findById(20L).ifPresent(board -> boardRepo.delete(board));
        log.info("삭제완료");
    }

    /**
     * 페이징처리
     * */
    @Test
    @DisplayName("페이징처리")
    public void test6() {
        //Pageable pageable =PageRequest.of(2, 5);// 페이지번호 0부터시작
        Pageable pageable = PageRequest.of(1, 5 , Sort.by("bno").descending());

        Page<Board> page = boardRepo.findAll(pageable);
        System.out.println("***********************************");
        System.out.println("page.getTotalElements() = "+page.getTotalElements());
        System.out.println("page.getNumber() = "+page.getNumber());
        System.out.println("page.getSize() = "+page.getSize());
        System.out.println("page.getTotalPages() = "+page.getTotalPages());
        System.out.println("page.previousPageable() = "+page.previousPageable());
        System.out.println("page.nextPageable() = "+page.nextPageable());

        System.out.println("page.isFirst() = "+page.isFirst());
        System.out.println("page.isLast() = "+page.isLast());
        System.out.println("page.hasNext() = "+page.hasNext());
        System.out.println("page.hasPrevious() = "+page.hasPrevious());
        System.out.println("***********************************");
        page.getContent().forEach(System.out::println);

    }

}
