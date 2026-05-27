package com.web;

import com.web.domain.Member;
import com.web.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class RegisterTests {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepository;

    /**
     * 패스워드 암호화 테스트
     * */
    @Test
    @DisplayName("암호화 test")
    void passWordTest(){
        String rawPassword = "8253jang";

        String encodedPassword = passwordEncoder.encode(rawPassword);
        log.info("encodedPassword:{}",encodedPassword);

        boolean isPasswordMatch = passwordEncoder.matches(rawPassword,encodedPassword);
        log.info("isPasswordMatch:{}",isPasswordMatch);
    }

    /**
     * 관리자 등록
     * */
    @Test
    @DisplayName("관리자 계정추가")
    void memberInsert(){
        String encPwd = passwordEncoder.encode("1234");

        memberRepository.save(
                Member.builder()
                        .id("admin")
                        .pwd(encPwd)
                        .name("이효리")
                        .role("ROLE_ADMIN")
                        .address("오리역")
                        .build());
    }

}
