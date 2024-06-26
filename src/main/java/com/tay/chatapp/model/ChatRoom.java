package com.tay.chatapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ChatRoom {
	
	@Id
	private String id;
	private String chatId;
	private String senderId;
	private String recipientId;
	
	public ChatRoom(String chatId, String senderId, String recipientId) {
		this.chatId = chatId;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}
}
