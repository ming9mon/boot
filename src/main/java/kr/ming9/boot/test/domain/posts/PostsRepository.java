package kr.ming9.boot.test.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {   //entity 클래스, pk 타입
}
