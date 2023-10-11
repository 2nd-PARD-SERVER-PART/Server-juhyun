package com.pard.hw3.service;

import com.pard.hw3.dto.ResponseDto;
import com.pard.hw3.dto.SignItem;
import com.pard.hw3.entity.ItemEntity;
import com.pard.hw3.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
//    addItem, findByName, findAll, updateItem, deleteItem,

    public ItemEntity findById(Integer itemId){
        return itemRepository.findById(itemId).get();
    }
//  이름 검색
    public ItemEntity findByName(String itemName){
        return itemRepository.findByItemName(itemName).get();
    }

//    중복 체크
    private boolean duplicateItemName(String itemName){
        Optional<ItemEntity> byName = itemRepository.findByItemName(itemName);
        return byName.isPresent();
    }
//    item 추가
    @Transactional
    public ResponseDto<ItemEntity> addItem(SignItem item){
        String itemName= item.getItemName();
        Integer itemPrice = item.getItemPrice();
        Integer itemQuantity = item.getItemQuantity();

        try {
            if(duplicateItemName(itemName)){
                return ResponseDto.setFailed("이미 있는 이름입니다");
            }
            if(itemPrice>50000){
                return ResponseDto.setFailed("5만원 넘음");
            }
            ItemEntity itemEntity = new ItemEntity(itemName,itemPrice,itemQuantity);
            itemRepository.save(itemEntity);
            return ResponseDto.setSuccess("상품 등록", itemEntity);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB에러");
        }

    }

    public ResponseDto<List<ItemEntity>> findAll(){
        List<ItemEntity> items;
        try {
            items = itemRepository.findAll();
            return ResponseDto.setSuccess("전부 찾았습니다",items);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("실패했습니다");
        }
    }

    @Transactional
    public ResponseDto<ItemEntity> updateItem(String itemName,SignItem signItem){
        ItemEntity itemEntity;
        itemEntity = itemRepository.findByItemName(itemName).get();
        try {
            itemEntity.setItemName(signItem.getItemName());
            itemEntity.setItemQuantity(signItem.getItemQuantity());
            if(signItem.getItemPrice()<50000){
                itemEntity.setItemPrice(signItem.getItemPrice());
            } else{
                return ResponseDto.setFailed("값이 5만원을 넘겼음");
            }
            return ResponseDto.setSuccess("업데이트 성공", null);
        } catch (Exception e){
           return   ResponseDto.setFailed("업데이트 실패");
        }

    }

    @Transactional
    public ResponseDto<?> deleteItem(Integer itemId){
        try {
            if(itemRepository.existsById(itemId)){
                itemRepository.deleteById(itemId);
                return ResponseDto.setSuccess("삭제완료", null);
            }
            else{
                return ResponseDto.setFailed("id없음");
            }
        } catch (Exception e){
            return ResponseDto.setFailed("DB에러");
        }
    }
//  최신순으로 정렬
    public ResponseDto<List<ItemEntity>> listByDate(){
        List<ItemEntity> items;
        try {
            items = itemRepository.findAllByOrderByItemTimeDesc();
            return ResponseDto.setSuccess("최신순서로 정렬", items);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("정렬 실패");
        }
    }

    public List<ItemEntity> showLimitPrice(Integer price){
        List<ItemEntity> items;
        items = itemRepository.findAllByItemPriceBefore(price);
        return items;
    }

    public List<ItemEntity> showKeyword(String Keyword){
        List<ItemEntity> items;
        items = itemRepository.findAllByItemNameContainingIgnoreCase(Keyword);
        return items;
    }

}
