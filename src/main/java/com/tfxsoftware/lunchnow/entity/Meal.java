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
    private String Name;
    private Float Price;
    private String Idr;
    private String mealImgUrl;
    
    public Meal(String name, Float price, String idr, String mealImgUrl) {
        this.Name = name;
        this.Price = price;
        this.Idr = idr;
        this.mealImgUrl = mealImgUrl;
    }

}
