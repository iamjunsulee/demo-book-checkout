package me.junsu.book.mapper;

import me.junsu.book.domain.Book;
import me.junsu.book.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDto, Book> {
}
