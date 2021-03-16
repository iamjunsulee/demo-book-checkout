package me.junsu.book.controller;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.BookDto;
import me.junsu.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public String getBooks(Model model) {
        List<BookDto> books = bookService.getBooks();
        model.addAttribute("bookList", books);
        return "/book/list";
    }

    @GetMapping("{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        BookDto bookDto = bookService.getBookById(id);
        model.addAttribute("bookList", bookDto);
        return "/book/list";
    }
}
