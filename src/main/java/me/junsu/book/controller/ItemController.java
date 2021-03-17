package me.junsu.book.controller;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.ItemDto;
import me.junsu.book.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/add")
    @ResponseBody
    public String saveItem(@RequestBody ItemDto itemDto) {
        itemService.saveBook(itemDto);
        return "success";
    }

    @GetMapping("/list")
    public String getItems(Model model) {
        List<ItemDto> books = itemService.getBooks();
        model.addAttribute("items", books);
        return "/item/list";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable Long id, Model model) {
        ItemDto itemDto = itemService.getBookById(id);
        model.addAttribute("items", itemDto);
        return "/item/list";
    }
}
