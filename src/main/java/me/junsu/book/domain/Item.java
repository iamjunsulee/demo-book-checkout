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
        name = "ITEM_SEQ_GENERATOR",
        allocationSize = 1,
        sequenceName = "ITEM_SEQ"
)
public class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GENERATOR"
    )
    @Column(name = "item_id")
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private Integer price;

    private LocalDateTime publishDate;

    @Builder
    public Item(String title, String author, String publisher, Integer price, LocalDateTime publishDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.publishDate = publishDate;
    }
}
