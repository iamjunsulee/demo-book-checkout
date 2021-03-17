package me.junsu.book.mapper;

import me.junsu.book.domain.Item;
import me.junsu.book.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDto, Item> {
}
