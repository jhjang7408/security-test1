package com.temisone.security1.repository;

import com.temisone.security1.domain.Member;
import com.temisone.security1.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

public interface MemberRepository extends CrudRepository<Member, String> {

}
