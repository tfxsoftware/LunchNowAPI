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
    private long Idm;
    private String name;
    private String price;
    private Restaurant restaurant;

}
