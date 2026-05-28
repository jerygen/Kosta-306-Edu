package web.mvc.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.mvc.domain.Member;
import web.mvc.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    //UserDetailService는 Provider가 자동으로 호출 할 거임
    //이제 여기서 MySQL DB에 연동하면 됨
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username={}", username);
        //username(id)에 해당하는 정보를 조회
        //비밀번호는 내부적으로 비교
        Member member = memberRepository.findById(username);
        if(member != null) {//있다.
            log.info("member={}", member);
            return new CustomMemberDetails(member);
        }

        return null;
    }

}
