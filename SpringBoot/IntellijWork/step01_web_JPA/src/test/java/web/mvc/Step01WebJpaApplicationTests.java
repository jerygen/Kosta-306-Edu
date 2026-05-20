package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //통합 테스트, 프로젝트 전체를 test
@Slf4j
class Step01WebJpaApplicationTests {

    @BeforeEach
    public void beforeEach() {
        log.info("BeforeEach ...");
    }

    @AfterEach
    public void afterEach() {
        log.info("AfterEach ...");
    }

    @Test
    @DisplayName("기본test")
    void contextLoads() {
        log.info("기본 test입니다.");

    }

}
