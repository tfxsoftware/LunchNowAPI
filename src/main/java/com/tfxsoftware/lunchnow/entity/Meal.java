package com.tfxsoftware.lunchnow.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    private String Idm;
    private String name;
    private float price;
    private String Idr;
    private String mealImgUrl;
    
    public Meal(String name, float price, String idr, String mealImgUrl) {
        this.name = name;
        this.price = price;
        this.Idr = idr;
        this.mealImgUrl = mealImgUrl;
    }

}
