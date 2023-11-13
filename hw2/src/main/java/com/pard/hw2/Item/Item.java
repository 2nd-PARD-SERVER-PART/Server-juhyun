package com.pard.hw2.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int id;
    private String pName;
    private int price;
    private int pNumber;
}
