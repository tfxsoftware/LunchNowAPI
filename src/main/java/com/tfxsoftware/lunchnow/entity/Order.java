package com.tfxsoftware.lunchnow.entity;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<String> Idm;
    private float totalPrice;
    public Order(LocalDateTime orderDate, String idr, String idu, List<String> idm, float totalPrice) {
        this.orderDate = orderDate;
        this.Idr = idr;
        this.Idu = idu;
        this.Idm = idm;
        this.totalPrice = totalPrice;
    }


}
