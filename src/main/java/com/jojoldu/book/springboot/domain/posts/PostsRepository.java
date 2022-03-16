package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 보통 i.MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자
// JPA 에서는 Repository 라고 부르며 인터페이스로 생성 <Entity클래스, PK타입> 을 상속하면 기본 CRUD 메서드 자동 생성
// @Repo 추가할 필요 X
// *** Entity클래스와 기본 Entity Repository는 함께 위치해야함. Entity클래스는 기본 Repository 없이는 제대로 동작X ***
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
