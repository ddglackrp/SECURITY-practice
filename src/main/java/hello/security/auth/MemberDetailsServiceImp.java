package hello.security.auth;

import hello.security.domain.Member;
import hello.security.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImp implements UserDetailsService {

    private final MemberRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = userRepository.findByUserName(username);
        if(memberEntity != null){
            return new MemberDetailsImp(memberEntity);
        }
        return null;
    }
}
