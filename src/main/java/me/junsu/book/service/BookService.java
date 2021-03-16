package me.junsu.book.service;

import me.junsu.book.dto.BookDto;

import java.util.List;

public interface BookService {
    Long saveBook(BookDto bookDto);
    List<BookDto> getBooks();
    BookDto getBookById(Long id);
}
