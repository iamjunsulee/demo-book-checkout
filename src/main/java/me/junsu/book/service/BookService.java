package me.junsu.book.service;

import me.junsu.book.dto.BookDto;

public interface BookService {
    Long saveBook(BookDto bookDto);
}
