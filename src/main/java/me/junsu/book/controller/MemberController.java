package me.junsu.book.controller;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.MemberDto;
import me.junsu.book.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/add")
    @ResponseBody
    public String saveMember(@RequestBody MemberDto memberDto) {
        memberService.saveMember(memberDto);
        return "success";
    }
}
