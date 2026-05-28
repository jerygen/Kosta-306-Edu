package web.mvc.service;

import web.mvc.domain.Member;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MemberAuthenticationException;
import web.mvc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; //회원가입할 때 비밀번호를 암호화하기 위해 주입

    @Transactional(readOnly = true)
    @Override
    public String duplicateCheck(String id) {
        Member member = memberRepository.dupilicateCheck(id);
        System.out.println("member="+member);
        if(member == null) return "사용가능합니다";
        else return "중복입니다.";
    }

    @Transactional
    @Override
    public void signUp(Member member) {
        if(memberRepository.existsById(member.getId())){
            throw new MemberAuthenticationException(ErrorCode.DUPLICATED);
        }
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        member.setRole("ROLE_USER");

        Member m = memberRepository.save(member);
        log.info("m="+m);
    }

}
