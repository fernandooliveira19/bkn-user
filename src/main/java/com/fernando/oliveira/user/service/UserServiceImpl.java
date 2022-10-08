package com.fernando.oliveira.user.service;

import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.mapper.UserMapper;
import com.fernando.oliveira.user.domain.request.CreateUserRequest;
import com.fernando.oliveira.user.domain.response.UserRoleResponse;
import com.fernando.oliveira.user.exception.UserException;
import com.fernando.oliveira.user.repository.UserRepository;
import com.fernando.oliveira.user.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDetailResponse findById(UUID id) {

        return userMapper.entityToResponse(userRepository.findById(id)
                .orElseThrow(
                () -> new UserException("Não foi encontrado usuario pelo id: " + id)
        ));
    }

    public UserRoleResponse loadUserByUsername(String username) {

        return userRepository
                .findByEmail(username)
                .map((e) -> userMapper.entityToUserRoleResponse(e))
                        .orElseThrow(
                () -> new UserException("Não foi encontrado usuario pelo email: " + username)
        );
    }

    @Override
    public UserDetailResponse create(CreateUserRequest request) {
        User userToCreate = userMapper.createUserRequestToEntity(request);

        //encrypt password
        userToCreate.setPassword(PasswordUtils.encryptPassword(request.getPassword()));
        User userCreated = userRepository.save(userToCreate);

        return userMapper.entityToResponse(userCreated);
    }


}
