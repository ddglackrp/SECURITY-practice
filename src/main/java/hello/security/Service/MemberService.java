package hello.security.Service;

import hello.security.Repository.MemberRepository;
import hello.security.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository userRepository;

    public Member join(Member member, String password){
        member.setPassword(password);
        member.setRole("ROLE_USER");
        userRepository.save(member);
        return member;
    }
}
