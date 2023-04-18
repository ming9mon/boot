package kr.ming9.boot.testWeb.service;


import kr.ming9.boot.testWeb.doamin.posts.Posts;
import kr.ming9.boot.testWeb.doamin.posts.PostsRepository;
import kr.ming9.boot.testWeb.dto.PostsListResponseDto;
import kr.ming9.boot.testWeb.web.dto.PostsResponseDto;
import kr.ming9.boot.testWeb.web.dto.PostsSaveRequestDto;
import kr.ming9.boot.testWeb.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto reqDto){
        return postsRepository.save(reqDto.toEntity()).getId();
    }

    /**
     * update 쿼리를 날리는 부분이 없는 이유는 JPA의 영속성 컨텍스트 때문
     * 영속성 컨텍스트 : 엔티티를 영구 저장하는 환경으로 일종의 논리적 개념
     * JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈림
     *
     * JPA의 엔티티 매니저가 활설화된 상태로(jpa를 쓴다면 기본 옵션) 트랜잭션 안에서 데이터베이스에서
     * 데티어를 가져오면 이 데이터는 영송석 컨텍스트가 유지된 상태
     *
     * 이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경부분을 반영
     * 즉, Entity객체의 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없음
     * 이 개념을 "더티 체킹"이라고 함
     * @param id
     * @param reqDto
     * @return
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto reqDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(reqDto.getTitle(), reqDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(posts);
    }
}
