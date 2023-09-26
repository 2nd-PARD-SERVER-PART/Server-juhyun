package com.pard.hw2.controller;

import com.pard.hw2.Item.Item;
import com.pard.hw2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

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
        itemRepository.save(item);
        return "add 완료" + item.getId();
    }

    @GetMapping("/findAll")
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @GetMapping("/findOne/{id}")
    public Item findOne(@PathVariable Integer id){
        return itemRepository.findById(id);
    }
    @PatchMapping ("/update/{id}")
    public void updateItem(@PathVariable Integer id, @RequestBody Item upitem){
        itemRepository.update(id,upitem);
    }
//delete 성공
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        itemRepository.delete(id);
    }
}
