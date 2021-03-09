package me.junsu.book.service.impl;

import lombok.RequiredArgsConstructor;
import me.junsu.book.domain.Member;
import me.junsu.book.dto.MemberDto;
import me.junsu.book.mapper.MemberMapper;
import me.junsu.book.repository.MemberRepository;
import me.junsu.book.service.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;    //constructor injection
    private final MemberMapper memberMapper;              //DTO - Entity conversion

    @Override
    public Long saveMember(MemberDto memberDto) {
        Member savedMember = memberRepository.save(memberMapper.toEntity(memberDto));
        return savedMember.getId();
    }
}
