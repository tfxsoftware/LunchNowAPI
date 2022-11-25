package com.tfxsoftware.lunchnow.entity;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    
    @Id
    private String Ido;
    private LocalDateTime orderDate;
    private String Idr;
    private String Idu;
    private String[] Idms;
    private float totalPrice;
    public Order(LocalDateTime orderDate, String idr, String idu, String[] idms, float totalPrice) {
        this.orderDate = orderDate;
        this.Idr = idr;
        this.Idu = idu;
        this.Idms = idms;
        this.totalPrice = totalPrice;
    }


}
