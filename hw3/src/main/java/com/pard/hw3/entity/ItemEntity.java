package com.pard.hw3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "item")
//item이라는 table 생성한다
public class ItemEntity {
//    itemId가 pk값이 된다
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Integer itemPrice;
    @Column(nullable = false)
    private Integer itemQuantity;

    @CreationTimestamp
    private Timestamp itemTime;

    public ItemEntity(String itemName, Integer itemPrice, Integer itemQuantity){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
}
