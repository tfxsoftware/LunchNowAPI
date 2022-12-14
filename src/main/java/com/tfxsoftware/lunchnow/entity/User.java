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
public class User {

	@Id
	private String idu;
	private String name;
	private String cpf;
	private String email;
	private String password;
	private String userImgUrl;
	
	public User(String name, String cpf, String email, String password, String userImgUrl) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.userImgUrl = userImgUrl;
	}

}
