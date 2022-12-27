package com.fernando.oliveira.user.domain.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleResponse implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<RoleResponse> roles;
}
