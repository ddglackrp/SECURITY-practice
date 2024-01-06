package hello.security;

import hello.security.domain.User;
import hello.security.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("1234");
        user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
        user1.setEmail("user1@gmail.com");
        user1.setRole("ROLE_ADMIN");

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("1234");
        user2.setPassword(bCryptPasswordEncoder.encode(user2.getPassword()));
        user2.setEmail("user2@gmail.com");
        user2.setRole("ROLE_USER");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
