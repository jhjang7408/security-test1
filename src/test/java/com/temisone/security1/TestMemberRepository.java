package com.temisone.security1;


import com.temisone.security1.domain.Member;
import com.temisone.security1.domain.Role;
import com.temisone.security1.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestMemberRepository {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void A01_사용자_등록(){
        Member member = new Member();

        member.setId("admin");
        member.setPassword(passwordEncoder.encode("admin"));
        member.setDname("admin부서");
        member.setEnabled(true);
        member.setRole(Role.ROLE_ADMIN);
        memberRepository.save(member);


        member = new Member();
        member.setId("manager");
        member.setPassword(passwordEncoder.encode("manager"));
        member.setDname("manager부서");
        member.setEnabled(true);
        member.setRole(Role.ROLE_MANAGER);
        memberRepository.save(member);



        member = new Member();
        member.setId("member");
        member.setPassword(passwordEncoder.encode("member"));
        member.setDname("member부서");
        member.setEnabled(true);
        member.setRole(Role.ROLE_MEMBER);
        memberRepository.save(member);
    }



}
