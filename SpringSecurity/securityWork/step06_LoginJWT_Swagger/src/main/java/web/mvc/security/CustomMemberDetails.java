package web.mvc.security;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import web.mvc.domain.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Slf4j
public class CustomMemberDetails implements UserDetails {
    private final Member member;
    public CustomMemberDetails(Member member) {
        this.member = member;
        log.info("CustomMemberDetails : {}", member);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("getAuthorities.....");
        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
        //role이 DB에는 그냥 String으로 저장되어 있는데
        //자바에서는 GrantedAuthority 타입이 되어야 하므로 타입을 변환해주는 작업을 한 것
        collection.add(()->member.getRole()); // ROLE_xx저장

        return collection;
    }

    @Override
    public String getPassword() {
        log.info("getPassword....");
        return member.getPwd();
    }

    @Override
    public String getUsername() {
        log.info("getUsername....");
        return member.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        log.info("isAccountNonExpired....");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        log.info("isAccountNonLocked....");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        log.info("isCredentialsNonExpired....");
        return true;
    }

    @Override
    public boolean isEnabled() {
        log.info("isEnabled....");
        return true;
    }
}
