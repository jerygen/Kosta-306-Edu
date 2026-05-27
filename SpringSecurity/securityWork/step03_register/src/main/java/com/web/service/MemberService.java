package com.web.service;

import com.web.domain.Member;

public interface MemberService {
    String duplicateCheck(String id);

    /**
     * 가입
     * */
    void signUp(Member member);
}
