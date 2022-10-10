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
public class Restaurant {
    @Id
    private long Idr;
    private String name;
    private String local;
    private LocalDateTime registryDate;
    private String email;
    private String password;
}
