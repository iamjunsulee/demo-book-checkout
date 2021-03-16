package me.junsu.book.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "BOOK_SEQ_GENERATOR",
        allocationSize = 1,
        sequenceName = "BOOK_SEQ"
)
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BOOK_SEQ_GENERATOR"
    )
    @Column(name = "book_id")
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private Integer price;

    private LocalDateTime publishDate;

    @Builder
    public Book(String title, String author, String publisher, Integer price, LocalDateTime publishDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.publishDate = publishDate;
    }
}
