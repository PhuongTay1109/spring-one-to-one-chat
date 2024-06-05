package com.tay.chatapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tay.chatapp.model.Status;
import com.tay.chatapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	List<User> findByStatus(Status status);
}
