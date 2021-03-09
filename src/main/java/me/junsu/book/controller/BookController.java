package me.junsu.book.controller;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.BookDto;
import me.junsu.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/add")
    @ResponseBody
    public String saveBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
        return "success";
    }
}
