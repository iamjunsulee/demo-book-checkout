package me.junsu.book.service;

import me.junsu.book.dto.MemberDto;

public interface MemberService {
    Long saveMember(MemberDto memberDto);
}
