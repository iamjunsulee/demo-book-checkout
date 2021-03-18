package me.junsu.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private Long id;
    @NotEmpty(message = "이름은 입력해야합니다.")
    private String name;
    @Min(
            value = 1000,
            message = "가격은 1000원 이상만 입력가능합니다."
    )
    private int price;
    @Min(
            value = 1,
            message = "재고수량은 1개 이상만 입력가능합니다."
    )
    private int stockQuantity;
}
