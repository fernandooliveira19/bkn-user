package com.fernando.oliveira.user.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserRoleResponse implements Serializable {
    private String name;
    private String email;
    private List<RoleResponse> roles;
}
