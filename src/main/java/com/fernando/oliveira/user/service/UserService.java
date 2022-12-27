package com.fernando.oliveira.user.service;

import com.fernando.oliveira.user.domain.entity.User;

import java.util.UUID;


public interface UserService {


	User findById(UUID id);

	User loadUserByUsername(String username);

	User create(User user);
}
