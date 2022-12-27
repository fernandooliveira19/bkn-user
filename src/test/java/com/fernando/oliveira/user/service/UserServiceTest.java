package com.fernando.oliveira.user.service;

import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.exception.UserException;
import com.fernando.oliveira.user.mother.UserMother;
import com.fernando.oliveira.user.repository.UserRepository;
import com.fernando.oliveira.user.service.impl.UserServiceImpl;
import com.fernando.oliveira.user.utils.MessageUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessageUtils messageUtils;

    @Test
    public void shouldReturnUserById(){
        User userSaved = UserMother.getUser();
        Mockito.when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(userSaved));

        User result = userService.findById(UUID.randomUUID());

        then(result.getName()).isEqualTo(userSaved.getName());
        then(result.getEmail()).isEqualTo(userSaved.getEmail());

    }


    @Test
    public void shouldReturnExceptionWhenUserNotFoundById(){
        UUID uuid = UUID.randomUUID();

        when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());
        when(messageUtils.getMessage(any(),any())).thenReturn("Não foi encontrado usuario pelo id: " + uuid.toString());

        Exception exception = assertThrows(UserException.class, () ->{
            userService.findById(uuid);
        });

        then(exception.getMessage()).isEqualTo("Não foi encontrado usuario pelo id: " + uuid.toString());

    }

    @Test
    public void shouldReturnUserByEmail(){
        User userSaved = UserMother.getUser();
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(userSaved));

        String username = "email.teste@teste.com";

        User result = userService.loadUserByUsername(username);

        then(result.getName()).isEqualTo(userSaved.getName());
        then(result.getEmail()).isEqualTo(userSaved.getEmail());

    }

    @Test
    public void shouldReturnExceptionWhenUserNotFoundByEmail(){
        String email = "not.found@teste.com";

        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        when(messageUtils.getMessage(any(),any())).thenReturn("Não foi encontrado usuario pelo email: " + email);

        Exception exception = assertThrows(UserException.class, () ->{
            userService.loadUserByUsername(email);
        });

        then(exception.getMessage()).isEqualTo("Não foi encontrado usuario pelo email: " + email);

    }

    @Test
    public void shouldReturnUserSavedWhenCreatedUser(){

        User userSaved = UserMother.getUser();
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(userSaved);

        User user = UserMother.getUser("new user", "password", "email.teste@teste.com.br");

        User result = userService.create(user);

        then(result.getName()).isEqualTo(userSaved.getName());
        then(result.getEmail()).isEqualTo(userSaved.getEmail());

    }
}
