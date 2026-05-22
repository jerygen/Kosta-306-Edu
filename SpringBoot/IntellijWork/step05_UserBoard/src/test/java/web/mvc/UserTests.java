package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.mvc.domain.User;
import web.mvc.repository.UserRepository;

@SpringBootTest
@Slf4j
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test(){
        userRepository.save(new User("lee", "1234","이효리"));
        userRepository.save(new User("jang", "1234","장근석"));
        userRepository.save(new User("song", "1234","송지효"));
    }
}
