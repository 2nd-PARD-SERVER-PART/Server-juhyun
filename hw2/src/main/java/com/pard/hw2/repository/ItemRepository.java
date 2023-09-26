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
        items.put(item.getId(),item);
        return item;
    }

    public Item findById(Integer id){
        return items.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(items.values());
    }

    public void update(Integer id, String pName, Integer price, Integer pNumber){
        Item wantToUpdate = findById(id);
        wantToUpdate.setPrice(price);
        wantToUpdate.setPName(pName);
        wantToUpdate.setPNumber(pNumber);
    }

    public void delete(Integer id){
        items.remove(id);
    }

}
