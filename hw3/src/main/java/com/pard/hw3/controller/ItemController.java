package com.pard.hw3.controller;

import com.pard.hw3.dto.ResponseDto;
import com.pard.hw3.dto.SignItem;
import com.pard.hw3.entity.ItemEntity;
import com.pard.hw3.service.ItemService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public ResponseDto<ItemEntity> addItem(@RequestBody SignItem item){
        return itemService.addItem(item);
    }

    @GetMapping("/findAll")
    public ResponseDto<List<ItemEntity>> findAll(){
        return itemService.findAll();
    }

    @PatchMapping("/update")
    public ResponseDto<ItemEntity> updateItem(@RequestBody SignItem item){
        return itemService.updateItem(item.getItemName(), item);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseDto<?> deleteItem(@PathVariable("id") Integer id ){
        return itemService.deleteItem(id);
    }
//    최신 등록 순서로 보여주기
    @GetMapping("/sortByTime")
    public ResponseDto<List<ItemEntity>> listByDate(){
        return itemService.listByDate();
    }
//  일정 가격 아래로 찾기
    @GetMapping("/underLimit/{price}")
    public List<ItemEntity> showLimitPrice(@PathVariable("price")Integer price){
        return itemService.showLimitPrice(price);
    }

//    keyword로 찾기
    @GetMapping("/searchByKeyword/{key}")
    public List<ItemEntity> showKeyword(@PathVariable("key") String Keyword){
        return itemService.showKeyword(Keyword);
    }
}
