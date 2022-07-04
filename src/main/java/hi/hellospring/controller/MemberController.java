package hi.hellospring.controller;

import hi.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    // ctrl + shift + n = action

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
