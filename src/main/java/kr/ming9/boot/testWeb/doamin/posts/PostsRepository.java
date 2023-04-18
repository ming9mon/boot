package kr.ming9.boot.testWeb.doamin.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 보통 Mybatis 에서는 Dao라고 불리지만, JPA에서는 Repository라고 부르며 Interface로 생성
 * Eintity(Posts)와 함께 위치해야함
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
