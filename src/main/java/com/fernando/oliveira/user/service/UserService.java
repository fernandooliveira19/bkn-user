package com.fernando.oliveira.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.oliveira.user.entity.User;
import com.fernando.oliveira.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public User findById(Long id) {
		
		return repository.findById(id).orElseThrow();
	}

	public User findByEmail(String email) {
		
		return repository.findByEmail(email).orElseThrow();
	}

}
