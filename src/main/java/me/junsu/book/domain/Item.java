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

    private String name;

    private int price;

    private int stock;

    @Builder
    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
