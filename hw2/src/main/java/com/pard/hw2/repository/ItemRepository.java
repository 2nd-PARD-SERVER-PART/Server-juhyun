package com.pard.hw2.repository;

import com.pard.hw2.Item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Integer, Item> items = new HashMap<>();

    //put, update, findById, findAll, delete
    public Item save(Item item){
//        id 1추가 하고 put할 때 추가한 값으로 저장
        item.setId(items.size()+1);
        items.put(item.getId(), item);
        return item;
    }

    public Item findById(Integer id){
        return items.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(items.values());
    }

    public void update(Integer id, Item updateItem){
        Item wantToUpdate = findById(id);
        wantToUpdate.setPNumber(updateItem.getPNumber());
        wantToUpdate.setPrice(updateItem.getPrice());
        wantToUpdate.setPName(wantToUpdate.getPName());
    }

    public void delete(Integer id){
        items.remove(id);
    }

}
