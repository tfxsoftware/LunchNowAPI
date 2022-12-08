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
    private String idm;
    private String name;
    private Float price;
    private String idr;
    private String mealImgUrl;
    private String desc;
    private int minutesToPrepare;
    
    public Meal(String name, Float price, String idr, String mealImgUrl, String desc, int minutesToPrepare) {
        this.name = name;
        this.price = price;
        this.idr = idr;
        this.mealImgUrl = mealImgUrl;
        this.desc = desc;
        this.minutesToPrepare = minutesToPrepare;
    }

}
