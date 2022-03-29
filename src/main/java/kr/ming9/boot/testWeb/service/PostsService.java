package kr.ming9.boot.testWeb.service;

import kr.ming9.boot.testWeb.doamin.posts.PostsRepository;
import kr.ming9.boot.testWeb.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto reqDto){
        return postsRepository.save(reqDto.toEntity()).getId();
    }
}
