package kr.ming9.boot.testWeb.web.dto;

import kr.ming9.boot.testWeb.doamin.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가 생성함
 * Entity 클래스를 Req/Res 클래스로 사용하면 안 된다고 함
 * Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스
 * Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경됨
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
