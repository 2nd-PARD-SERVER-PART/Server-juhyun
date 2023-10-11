package com.pard.hw3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignItem {
//    private Integer itemId;
    private String itemName;
    private Integer itemPrice;
    private Integer itemQuantity;
//    private Timestamp itemTime;
}
