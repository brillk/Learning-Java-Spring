package hi.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//index.html을 설정했는데, 이게 먼저 나오는 이유: 우선순위
// 웹 브라우저 -> 내장 톰캣 서버 -> 1. 스프링 컨테이너(맵핑이 되어 있으면) 2. html(맵핑이 없으면)
// 맵핑이 된 파일로 먼저 출력됨

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
