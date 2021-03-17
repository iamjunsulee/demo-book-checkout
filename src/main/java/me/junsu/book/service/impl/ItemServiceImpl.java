package me.junsu.book.service.impl;

import lombok.RequiredArgsConstructor;
import me.junsu.book.domain.Item;
import me.junsu.book.dto.ItemDto;
import me.junsu.book.mapper.ItemMapper;
import me.junsu.book.repository.ItemRepository;
import me.junsu.book.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public Long saveItem(ItemDto itemDto) {
        Item savedItem = itemRepository.save(itemMapper.toEntity(itemDto));
        return savedItem.getId();
    }

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return itemMapper.toDto(item);
    }
}
