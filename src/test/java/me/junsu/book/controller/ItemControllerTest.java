package me.junsu.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.junsu.book.dto.ItemDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void 책_저장_테스트() throws Exception {
        ItemDto requestItemDto = new ItemDto();
        requestItemDto.setAuthor("leejunsu");
        requestItemDto.setPrice(18000);
        requestItemDto.setPublishDate(LocalDateTime.now());
        requestItemDto.setTitle("springframework");
        requestItemDto.setPublisher("꿈출판사");

        String jsonString = objectMapper.writeValueAsString(requestItemDto);

        this.mockMvc.perform(post("/book/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
        ;
    }
}