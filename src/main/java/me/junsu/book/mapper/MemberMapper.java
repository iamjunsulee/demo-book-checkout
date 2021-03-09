package me.junsu.book.mapper;

import me.junsu.book.domain.Member;
import me.junsu.book.dto.MemberDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper  extends EntityMapper<MemberDto, Member> {
}
