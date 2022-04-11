package kr.ming9.boot.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 로그인
     * @return
     */
    @GetMapping(value="/signIn")
    public String signIn(){
        return "/user/signIn";
    }

    /**
     * 회원가입
     * @return
     */
    @GetMapping(value="/signUp")
    public String signUp(){
        return "/user/signUp";
    }
}
