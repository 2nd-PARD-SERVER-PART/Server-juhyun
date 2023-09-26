package com.pard.hw2.controller;

import com.pard.hw2.Item.Item;
import com.pard.hw2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    @PostMapping("/add")
    public String add(@RequestBody Item item){
        item.setId(item.getId()+1);
        itemRepository.save(item);
        return "add 완료";
    }

    @GetMapping("/findAll")
    public List<Item> findAll(){
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }
}
