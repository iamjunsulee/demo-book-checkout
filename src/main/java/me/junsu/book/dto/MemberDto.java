package me.junsu.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class RequestMemberDto {
        private String name;
        private String phone;
    }
}
