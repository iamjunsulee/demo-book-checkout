package me.junsu.book.service;

import me.junsu.book.dto.ItemDto;

import java.util.List;

public interface ItemService {
    Long saveBook(ItemDto itemDto);
    List<ItemDto> getBooks();
    ItemDto getBookById(Long id);
}
