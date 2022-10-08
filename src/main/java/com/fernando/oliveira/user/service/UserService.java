package com.fernando.oliveira.user.service;

import com.fernando.oliveira.user.domain.request.CreateUserRequest;
import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.domain.response.UserRoleResponse;

import java.util.UUID;


public interface UserService {


	UserDetailResponse findById(UUID id);

	UserRoleResponse loadUserByUsername(String username);

	UserDetailResponse create(CreateUserRequest request);
}
