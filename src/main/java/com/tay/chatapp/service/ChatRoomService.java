package com.tay.chatapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tay.chatapp.model.ChatRoom;
import com.tay.chatapp.repository.ChatRoomRepository;

@Service
public class ChatRoomService {
	
	@Autowired
	private ChatRoomRepository chatRoomRepo;

	public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
		return chatRoomRepo.findBySenderIdAndRecipientId(senderId, recipientId)
					.map(ChatRoom::getChatId)
					.or(() -> {
						if(createNewRoomIfNotExists) {
							String chatId = createChatId(senderId, recipientId);
							return Optional.of(chatId);
						}
						return Optional.empty();
					});
	}

	private String createChatId(String senderId, String recipientId) {
		
		String chatId = String.format("%s_%s", senderId, recipientId);
		
		ChatRoom senderRecipient = new ChatRoom(chatId, senderId, recipientId);
        ChatRoom recipientSender = new ChatRoom(chatId, recipientId, senderId);

        chatRoomRepo.save(senderRecipient);
        chatRoomRepo.save(recipientSender);

        return chatId;
	}

}
