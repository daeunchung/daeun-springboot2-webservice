package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
// PostsResponseDto 는 Entity 의 필드 중 일부만 사용하므로 생성자로 Entity 를 받아 필드에 값을 넣는다.
// 굳이 모든 필드를 가진 생성자 필요 X => Dto 는 Entity 를 받아서 처리
