package com.fernando.oliveira.user.controller;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDetailResponse> findById(@PathVariable UUID id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findById(id));
	}
	
	@GetMapping(value="/loadUserByUsername")
	@ResponseStatus(HttpStatus.OK)
	public UserRoleResponse loadUserByUsername(@RequestParam String username){
		return userService.loadUserByUsername(username);

	}

	@PostMapping
	public ResponseEntity create(@RequestBody CreateUserRequest request){

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.build();
	}
	
}
