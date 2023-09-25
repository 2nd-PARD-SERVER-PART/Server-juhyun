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
        items.put(item.getPNumber(),item);
        return item;
    }

    public Item findById(Integer pNumber){
        return items.get(pNumber);
    }
    public List<Item> findAll(){
        return new ArrayList<>(items.values());
    }



    public void delete(Integer id){
        items.remove(id);
    }

}
