package me.junsu.book.service;

import me.junsu.book.dto.ItemDto;

import java.util.List;

public interface ItemService {
    Long saveItem(ItemDto itemDto);
    List<ItemDto> getItems();
    ItemDto getItemById(Long id);
}
