package me.junsu.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.junsu.book.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postmapping_저장_테스트() throws Exception {
        MemberDto.RequestMemberDto requestMemberDto = new MemberDto.RequestMemberDto();
        requestMemberDto.setName("leejunsu");
        requestMemberDto.setPhone("01012341234");
        String valueAsString = objectMapper.writeValueAsString(requestMemberDto);

        this.mockMvc.perform(post("/member/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(valueAsString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
        ;
    }
}