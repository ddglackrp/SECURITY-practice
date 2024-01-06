package hello.security.Repository;

import hello.security.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class UserRepository {

    private static Map<Long, User> memberStore = new HashMap<>();
    private static Long sequence = 0L;

    public User save(User user){
        log.info("savedUser = {}",user);
        user.setId(++sequence);
        memberStore.put(user.getId(),user);
        return user;
    }

    public User findByUserName(String userName){
        Optional<User> findUser = memberStore.values().stream()
                .filter(user -> user.getUsername().equals(userName))
                .findAny();

        return findUser.orElse(null);
    }
}
