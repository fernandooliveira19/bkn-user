package com.fernando.oliveira.user.controller;

import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.mapper.UserMapper;
import com.fernando.oliveira.user.domain.request.CreateUserRequest;
import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.domain.response.UserRoleResponse;
import com.fernando.oliveira.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDetailResponse> findById(@PathVariable UUID id){

		UserDetailResponse response = userMapper.entityToResponse(userService.findById(id));
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	@GetMapping(value="/loadUserByUsername")
	@ResponseStatus(HttpStatus.OK)
	public UserRoleResponse loadUserByUsername(@RequestParam String username){
		return userMapper.entityToUserRoleResponse(userService.loadUserByUsername(username));


	}

	@PostMapping
	public ResponseEntity<UserDetailResponse> create(@RequestBody CreateUserRequest request){
		User userToCreate = userMapper.createUserRequestToEntity(request);

		UserDetailResponse response = userMapper.entityToResponse(userService.create(userToCreate));

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(response);
	}
	
}
