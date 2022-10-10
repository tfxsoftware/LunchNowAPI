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
    private long Ido;
    private LocalDateTime orderDate;
    private Restaurant restaurant;
    private User user;


}
