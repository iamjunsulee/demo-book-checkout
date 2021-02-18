package me.junsu.book.service.impl;

import lombok.RequiredArgsConstructor;
import me.junsu.book.domain.Member;
import me.junsu.book.dto.MemberDto;
import me.junsu.book.repository.MemberRepository;
import me.junsu.book.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;    //constructor injection
    private final ModelMapper modelMapper;              //DTO - Entity conversion

    @Override
    public Long saveMember(MemberDto.RequestMemberDto requestMemberDto) {
        Member savedMember = memberRepository.save(modelMapper.map(requestMemberDto, Member.class));
        return savedMember.getId();
    }
}
