package kr.ming9.boot.testWeb.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController_T {

    @GetMapping("/test")
    public String index(){
        return "test/index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "test/posts-save";
    }
}
