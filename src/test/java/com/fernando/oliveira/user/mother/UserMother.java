package com.fernando.oliveira.user.mother;

import com.fernando.oliveira.user.domain.entity.Role;
import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMother {
    private static final String NAME = "username";
    private static final String EMAIL = "email.teste@teste.com";
    private static final String PASSWORD = "$2a$10$J4sjtoR2684kJ7eN8hhfv.oQMi3jsGrKI5fMB/wD3hErfYjLLvxLa";
    private static final UUID ID = UUID.randomUUID();


    public static User getUser(){
        Role role = RoleMother.getAdminRole();
        return User.builder()
                .name(NAME)
                .password(PASSWORD)
                .email(EMAIL)
                .roles(Set.of(role))
                .build();
    }


    public static UserDetailResponse getUserDetailResponse(User user) {
        return UserDetailResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}