package kr.ming9.boot.web.dto;

import kr.ming9.boot.doamin.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
