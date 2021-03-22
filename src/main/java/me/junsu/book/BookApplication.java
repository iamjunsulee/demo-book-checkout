package me.junsu.book;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.ItemDto;
import me.junsu.book.dto.MemberDto;
import me.junsu.book.service.ItemService;
import me.junsu.book.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
//@RequiredArgsConstructor
public class BookApplication {
//    private final MemberService memberService;
//    private final ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void dataLoad() {
//        System.out.println("ApplicationReadyEvent 실행 !!");
//        //member data load
//        MemberDto memberDto = new MemberDto();
//        memberDto.setName("이준수");
//        memberDto.setPhone("01012341234");
//        memberService.saveMember(memberDto);
//
//        //book data load
//        ItemDto itemDto = new ItemDto();
//        itemDto.setPrice(43000);
//        itemDto.setName("자바 ORM 표준 JPA 프로그래밍");
//        itemDto.setStockQuantity(1);
//        itemService.saveItem(itemDto);
//    }
}
