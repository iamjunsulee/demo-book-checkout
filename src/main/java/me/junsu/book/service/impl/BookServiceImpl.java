package me.junsu.book.service.impl;

import lombok.RequiredArgsConstructor;
import me.junsu.book.domain.Book;
import me.junsu.book.dto.BookDto;
import me.junsu.book.repository.BookRepository;
import me.junsu.book.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long saveBook(BookDto.RequestBookDto requestBookDto) {
        Book savedBook = bookRepository.save(modelMapper.map(requestBookDto, Book.class));
        return savedBook.getId();
    }
}
