package com.tay.chatapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tay.chatapp.model.ChatMessage;
import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
	
	List<ChatMessage> findByChatId(String chatId);
}
