package kr.ming9.boot.test.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Getter     // 롬복 어노테이션
@NoArgsConstructor  // 롬복 어노테이션 - 기본 생성자 자동 추가 public Posts(){} d와 같음
@Entity     // jpa 어노테이션 - 테이블과 링크될 클래스임을 나타냄
public class Posts {    // 실제 DB와 매칭 될 클래스

    @Id     // pk 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue : pk의 생성 규칙; IDENTITY = auto_increment
    private Long id;

    @Column(length = 500, nullable = false)     //테이블의 컬럼을 나타내며 선언하지 않아도 됨
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성; 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this. author = author;
    }
}
