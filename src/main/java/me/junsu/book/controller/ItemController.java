package me.junsu.book.controller;

import lombok.RequiredArgsConstructor;
import me.junsu.book.dto.ItemDto;
import me.junsu.book.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/add")
    public String saveItem(@ModelAttribute @Valid ItemDto itemDto,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/item/register";
        }
        itemService.saveItem(itemDto);
        return "redirect:/item/list";
    }

    @GetMapping("/add")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("itemDto", new ItemDto());
        return "/item/register";
    }

    @GetMapping("/list")
    public String getItems(Model model) {
        List<ItemDto> items = itemService.getItems();
        model.addAttribute("items", items);
        return "/item/list";
    }
}
