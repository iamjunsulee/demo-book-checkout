package me.junsu.book.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int totalPrice;

    /* 연관관계 메서드 */
    private void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    /* 연관관계 메서드 */
    private void setOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    /* 생성 메서드 */
    public static Order createOrder(Member member, OrderItem ... orderItems) {
        Order order = new Order();
        order.setMember(member);
        for(OrderItem orderItem : orderItems) {
            order.setOrderItems(orderItem);
        }
        return order;
    }
}
