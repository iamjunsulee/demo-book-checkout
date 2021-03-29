package me.junsu.book.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderQuantity;  //주문수량
    private int orderPrice;     //주문가격

    /* 생성메서드 */
    public static OrderItem createOrderItem(Item item, int count, int price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(price);
        orderItem.setItem(item);
        orderItem.setOrderQuantity(count);
        return orderItem;
    }
}
