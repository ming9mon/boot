package kr.ming9.boot.testWeb.doamin.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가 - pulic Posts(){} 와 같은 효과
@Entity             // 테이블과 링크될 클래스 - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts {

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK의 생성 규칙 / GenerationType.IDENTITY 는 auto_increment
    private long id;

    /**
     * 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
     * 사용 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
     * VACHAR255가 기본값이지만, 사이즈를 늘리거나 TEXT 타입으로 변경하고 싶을 경우 사용
    */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래싀의 빌더 패턴 클래스 생성 - 생ㅅ성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
