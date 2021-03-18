package me.junsu.book.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        allocationSize = 1,
        sequenceName = "MEMBER_SEQ"
)
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String phone;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
