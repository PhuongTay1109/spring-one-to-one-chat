package com.tay.chatapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tay.chatapp.model.ChatMessage;
import java.util.List;


public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
	
	List<ChatMessage> findByChatId(String chatId);
}
