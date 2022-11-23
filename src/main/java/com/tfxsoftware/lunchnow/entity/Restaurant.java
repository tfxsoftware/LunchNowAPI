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
public class Restaurant {
    @Id
    private String Idr;
    private String name;
    private String cnpj;
    private Address address;
    private String type;
    private String email;
    private String password;
    private String restaurantImgUrl;
    
    public Restaurant(String name, String cnpj, Address adress, String email, String type, String password,
            String restaurantImgUrl) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = adress;
        this.type = type;
        this.email = email;
        this.password = password;
        this.restaurantImgUrl = restaurantImgUrl;
    }
}
