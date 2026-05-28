package web.mvc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import web.mvc.jwt.JWTFilter;
import web.mvc.jwt.JWTUtil;
import web.mvc.jwt.LoginFilter;

@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class SecurityConfig {

    //AuthenticationManager가 인자로 받을 AuthenticationConfiguraion 객체 생성자 주입
    private final AuthenticationConfiguration authenticationConfiguration;

    private final JWTUtil jwtUtil;

    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        log.info("BCryptPasswordEncoder called....");
        return new BCryptPasswordEncoder(); //passwordEncoder의 구현체 중 하나, 이걸 사용해서 암호화하고 등록할 수 있음
    }

    /**
     * 인증과 인가에 관련된 정책 설정
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("SecurityFilterChain securityFilterChain(HttpSecurity http) called....");
        //csrf disable, react를 연결할 건데 리액트는 csrf 토큰을 가지고 있을 수 없음
        http.csrf((auth)->auth.disable());

        //form 로그인 방식 disable -> react, jwt 인증 방식 사용
        //로그인 폼을 react에서 만들거기 때문
        http.formLogin(auth->auth.disable());

        //httpBasic 인증 방식 disable
        //security는 폼 로그인 방식과 httpBasic 로그인 방식이 존재
        http.httpBasic(auth->auth.disable());

        //경로별 인가 작업
        http.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/index", "/members", "/members/**").permitAll()
                        //[1] GET 요청: 누구나 가능
                        .requestMatchers(HttpMethod.GET,"/boards").permitAll()
                        .requestMatchers(HttpMethod.GET,"/boards/**").permitAll()
                        //[2] POST 요청: 인증된 사용자만
                        .requestMatchers(HttpMethod.POST,"/boards").authenticated()
                        //[3] PUT 요청: 인증된 사용자만
                        .requestMatchers(HttpMethod.PUT,"/boards").authenticated()
                        //[4] DELETE 요청: 인증된 사용자만
                        .requestMatchers(HttpMethod.DELETE,"/boards").authenticated()
                        /**
                         * 사용자가 적어도 하나 이상 가졍하는 역할(예: ADMIN, USER 등)
                         * 각 역할은 ROLE_로 시작하면 안 됨. 내부에서 자동으로 붙기 때문이다.
                         * */
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers(
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll()
                        .anyRequest().authenticated());

        //로그인 필터 등록
        http.addFilterAt(new LoginFilter( this.authenticationManager(authenticationConfiguration) , jwtUtil) ,
                UsernamePasswordAuthenticationFilter.class);

        //JWTFilter 등록
        http.addFilterBefore(new JWTFilter(jwtUtil), LoginFilter.class);

        System.out.println("************************");
        SecurityFilterChain chain = http.build();
        chain.getFilters().forEach(System.out::println);
        System.out.println("************************");

        return chain;
    }

}
