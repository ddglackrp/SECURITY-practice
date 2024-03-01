package hello.security.domain;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;

}
