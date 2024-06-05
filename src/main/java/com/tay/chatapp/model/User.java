package com.tay.chatapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
	
	private String fullName;
	@Id
	private String nickName;
	private Status status;
}
