package com.web.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //환경설정을 돕는 클래스
@EnableWebSecurity //Spring Security를 활성화 시키는 어노테이션
@Slf4j
public class SecurityConfig {

    /**
     * SecurityFilterChain은 security 정책
     *  : HttpSecurity는 각 요청에 해당하는 정책들을 어떻게 할 것인지 결정
     *  ex) 어떤 정책은 무엇을 해야하고, 안 해도 되고, 해도되고 등의 옵션을 설정할 수 있다.
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        // 어떠한 요청도 인증이 필요
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        //기본 화면
        //http.formLogin(Customizer.withDefaults());

        //사용자정의 로그인 폼 설정
        http.formLogin(form->
                 form.loginPage("/loginPage")
                .loginProcessingUrl("/loginProc")
                //.defaultSuccessUrl("/",false)
                //.failureUrl("/failed")
                .usernameParameter("userId")
                .passwordParameter("userPass")
                .successHandler((request, response, authentication) -> {
                    System.out.println("authentication="+authentication);
                    response.sendRedirect("/home");
                })
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception="+exception);
                    response.sendRedirect("/loginPage");
                })
                .permitAll());

        http.csrf(csrf -> csrf.disable());

        SecurityFilterChain chain = http.build();
        System.out.println("************************************");
        chain.getFilters().forEach(filter -> {
            System.out.println(filter);
        });
        System.out.println("************************************");
        return chain;
    }

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
