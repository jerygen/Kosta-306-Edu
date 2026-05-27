package com.web.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration //환경설정을 돕는 클래스
@EnableWebSecurity //Spring Security를 활성화 시키는 어노테이션
@Slf4j
public class SecurityConfig {
    /**
     * 여러 명의 계정 추가 - inmemeory
     * */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("jang").password("{noop}1111").roles("USER").build());
        manager.createUser(User.withUsername("kim").password("{noop}2222").roles("USER").build());
        manager.createUser(User.withUsername("lee").password("{noop}3333").roles("USER", "ADMIN").build());

        return manager;
    }
}
