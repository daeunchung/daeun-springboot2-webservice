package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 보통 i.MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자
// JPA 에서는 Repository 라고 부르며 인터페이스로 생성 <Entity클래스, PK타입> 을 상속하면 기본 CRUD 메서드 자동 생성
// @Repo 추가할 필요 X
// *** Entity클래스와 기본 Entity Repository는 함께 위치해야함. Entity클래스는 기본 Repository 없이는 제대로 동작X ***
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringDataJpa 에서 제공하지 않는 메소드는 위처럼 쿼리 어노테이션으로 작성 가능
    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
