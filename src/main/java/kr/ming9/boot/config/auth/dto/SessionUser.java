package kr.ming9.boot.config.auth.dto;

import kr.ming9.boot.testWeb.doamin.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getEmail();
    }
}
