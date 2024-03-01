package hello.security.Repository;

import hello.security.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class MemberRepository {

    private static Map<Long, Member> memberStore = new HashMap<>();
    private static Long sequence = 0L;

    public Member save(Member member){
        log.info("savedUser = {}", member);
        member.setId(++sequence);
        memberStore.put(member.getId(), member);
        return member;
    }

    public Member findByUserName(String userName){
        Optional<Member> findUser = memberStore.values().stream()
                .filter(user -> user.getUsername().equals(userName))
                .findAny();

        return findUser.orElse(null);
    }
}
