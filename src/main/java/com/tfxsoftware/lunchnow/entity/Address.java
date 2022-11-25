package com.tfxsoftware.lunchnow.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Address {
    private String street;
    private String number;
    private double x;
    private double y;
    
    public Address() {}   
    public Address(String street, String number, double x, double y) {
        this.street = street;
        this.number = number;
        this.x = x;
        this.y = y;
    }

}
