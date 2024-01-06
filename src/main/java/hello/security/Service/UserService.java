package hello.security.Service;

import hello.security.Repository.UserRepository;
import hello.security.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User join(User user, String password){
        user.setPassword(password);
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return user;
    }
}
