package com.tay.chatapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tay.chatapp.model.Status;
import com.tay.chatapp.model.User;
import com.tay.chatapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public void saveUser(User user) {
		user.setStatus(Status.ONLINE);
		repo.save(user);		
	}
	
	public void disconnect(User user) {
		User existingUser = repo.findById(user.getNickName()).orElseThrow();
		existingUser.setStatus(Status.OFFLINE);
		repo.save(existingUser);		
	}
	
	public List<User> findConnectedUser() {
		return repo.findByStatus(Status.ONLINE);		
	}

}
