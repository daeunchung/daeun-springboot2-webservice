package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    // 머스테치 스타터로 인해 자동으로 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
    private final PostsService postsService;
//    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {  // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다
        // 여기서는 postsService.findAllDesc() 로 가져온 결과를 posts 로 index.mustache 에 전달
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        // 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser 를 저장하도록 구성.
        // 즉, 로그인 성공 시 httpSession.getAttribute("user") 에서 값을 가져올 수 있음

        if (user != null) {
            model.addAttribute("userName", user.getName());
        } // 세션에 저장된 값이 있을 때만 model 에 userName 등록. 세션에 값없으면 model에 값 없음 => 로그인 버튼 보이도록
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
