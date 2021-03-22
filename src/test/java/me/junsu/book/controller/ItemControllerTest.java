package me.junsu.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.junsu.book.dto.ItemDto;
import me.junsu.book.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ItemService itemService;

    @Test
    public void 책_저장_테스트() throws Exception {
        ItemDto requestItemDto = new ItemDto();
        requestItemDto.setPrice(18000);
        requestItemDto.setName("springframework");
        requestItemDto.setStockQuantity(1);

        String jsonString = objectMapper.writeValueAsString(requestItemDto);

        this.mockMvc.perform(post("/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
        ;
    }

    @Test
    public void 아이디로_조회하기_테스트() throws Exception {

        this.mockMvc.perform(get("/item/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}