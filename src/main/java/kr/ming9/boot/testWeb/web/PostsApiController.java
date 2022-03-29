package kr.ming9.boot.testWeb.web;

import kr.ming9.boot.testWeb.service.PostsService;
import kr.ming9.boot.testWeb.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Lombok에서 지원하는 @RequiredArgsConstructor 어노테이션을 사용하여 의존성을 주입 하는 것을 생성자 주입
 * 스프링 팀은 생성자 주입을 사용할 것을 권장
 *
 * 생성자 주입을 사용할 경우 아래와 같은 장점이 있다.
 *
 * ① 순환 참조 방지
 * ② 테스트 코드 작성 용이
 * ③ 코드 악취 제거
 * ④ 객체 변이 방지 (final 가능)
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService posetsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto reqDto){
        return posetsService.save(reqDto);
    }
}
