package com.tay.chatapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tay.chatapp.model.ChatMessage;
import com.tay.chatapp.repository.ChatMessageRepository;

@Service
public class ChatMessageService {
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	@Autowired
	private ChatRoomService chatRoomService;
	
	public ChatMessage save(ChatMessage chatMessage) {
		String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true).orElseThrow();
		chatMessage.setChatId(chatId);
		chatMessageRepository.save(chatMessage);
		return chatMessage;
	}
	
	public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
		String chatId = chatRoomService.getChatRoomId(senderId, recipientId, false).orElseThrow();
		return chatMessageRepository.findByChatId(chatId);
	}

}
