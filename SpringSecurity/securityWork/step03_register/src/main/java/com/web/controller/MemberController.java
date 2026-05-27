package com.web.controller;

import com.web.domain.Member;
import com.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/index")
    public String index(){
        log.info("index call...");
        return "Spring Security Setting 완료";
    }

    /**
     * 아이디 중복 체크
     * */
    @GetMapping("/members/{id}")
    public String duplicateCheck(@PathVariable String id){
        log.info("id={}", id);
        return memberService.duplicateCheck(id);
    }

    /**
     * 회원가입
     * */
    @PostMapping("/members")
    public String signUp(@RequestBody Member member){
        memberService.signUp(member);
        return "ok";
    }

}
