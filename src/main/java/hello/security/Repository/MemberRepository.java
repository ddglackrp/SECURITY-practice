package hello.security.Repository;

import hello.security.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberRepository {

    private final EntityManager em;

    @Transactional
    public Member save(Member member){
        log.info("savedUser = {}", member.getMemberName());
        em.persist(member);
        return member;
    }

    public Member findByMemberName(String memberName){
        List<Member> members = em.createQuery("select m from Member m where m.memberName = :name", Member.class)
                .setParameter("name", memberName)
                .getResultList();

        if(members.isEmpty()) return null;
        else return members.get(0);
    }
}
