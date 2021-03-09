package me.junsu.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Integer price;
    private LocalDateTime publishDate;
}
