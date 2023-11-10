package com.temisone.security1.config;

import com.temisone.security1.domain.Member;
import com.temisone.security1.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> op = memberRepository.findById(username);

        if(!op.isPresent()){
            throw new UsernameNotFoundException("사용자 없음");
        }

        Member member = op.get();

        return new SecurityUser(member);
    }

}
