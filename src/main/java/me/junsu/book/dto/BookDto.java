package me.junsu.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class BookDto {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class RequestBookDto {
        private String title;
        private String author;
        private String publisher;
        private Integer price;
        private LocalDateTime publishDate;
    }
}
