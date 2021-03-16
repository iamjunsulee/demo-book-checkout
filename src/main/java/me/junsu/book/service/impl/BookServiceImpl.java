package me.junsu.book.service.impl;

import lombok.RequiredArgsConstructor;
import me.junsu.book.domain.Book;
import me.junsu.book.dto.BookDto;
import me.junsu.book.mapper.BookMapper;
import me.junsu.book.repository.BookRepository;
import me.junsu.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Long saveBook(BookDto bookDto) {
        Book savedBook = bookRepository.save(bookMapper.toEntity(bookDto));
        return savedBook.getId();
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return bookMapper.toDto(book);
    }
}
