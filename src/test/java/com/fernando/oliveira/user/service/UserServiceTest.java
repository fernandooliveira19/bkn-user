package com.fernando.oliveira.user.service;

import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.mapper.UserMapper;
import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.mother.UserMother;
import com.fernando.oliveira.user.repository.UserRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    public void shouldReturnUserById(){
        User userSaved = UserMother.getUser();
        UserDetailResponse userDetailResponse = UserMother.getUserDetailResponse(userSaved);
        Mockito.when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(userSaved));
        Mockito.when(userMapper.entityToResponse(Mockito.any(User.class))).thenReturn(userDetailResponse);

        UserDetailResponse result = userService.findById(UUID.randomUUID());

        BDDAssertions.then(result.getName()).isEqualTo(userSaved.getName());
        BDDAssertions.then(result.getEmail()).isEqualTo(userSaved.getEmail());

    }


    @Test
    public void shouldReturnExceptionWhenUserNotFoundById(){

    }

    @Test
    public void shouldReturnUserByEmail(){

    }

    @Test
    public void shouldReturnExceptionWhenUserNotFoundByEmail(){

    }

    @Test
    public void shouldReturnUserSavedWhenCreatedUser(){

    }
}
