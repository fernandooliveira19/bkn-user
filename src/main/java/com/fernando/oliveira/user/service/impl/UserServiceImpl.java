package com.fernando.oliveira.user.service.impl;

import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.enums.ExceptionMessageEnum;
import com.fernando.oliveira.user.exception.UserException;
import com.fernando.oliveira.user.repository.UserRepository;
import com.fernando.oliveira.user.service.UserService;
import com.fernando.oliveira.user.utils.MessageUtils;
import com.fernando.oliveira.user.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageUtils messageUtils;

    public User findById(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(
                () -> new UserException(
                        messageUtils.getMessage(ExceptionMessageEnum.USER_NOT_FOUND_BY_ID.getMessageKey(), new Object[]{id}))
        );
    }

    public User loadUserByUsername(String username) {

        return userRepository
                .findByEmail(username)
                   .orElseThrow(
                () -> new UserException(messageUtils.getMessage(ExceptionMessageEnum.USER_NOT_FOUND_BY_EMAIL.getMessageKey(), new Object[]{username}))
        );
    }

    @Override
    public User create(User user) {

        user.setPassword(PasswordUtils.encryptPassword(user.getPassword()));
        return userRepository.save(user);

    }


}
