package com.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        log.info("BCryptPasswordEncoder called....");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("SecurityFilterChain securityFilterChain(HttpSecurity http) called....");
        //csrf disable
        http.csrf((auth)->auth.disable());

        //form 로그인 방식 disable -> react, jwt 인증 방식 사용
        http.formLogin(auth->auth.disable());

        //httpBasic 인증 방식 disable
        http.httpBasic(auth->auth.disable());

        //경로별 인가 작업
        http.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/index", "/members", "/members/**", "/boards").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated());

        return http.build();
    }

}
