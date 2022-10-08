package com.fernando.oliveira.user.mother;

import com.fernando.oliveira.user.domain.entity.Role;
import com.fernando.oliveira.user.domain.response.RoleResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleMother {

    private static final UUID ID = UUID.randomUUID();
    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    public static Role getAdminRole(){
        return Role.builder()
                .id(ID)
                .roleName(ADMIN)
                .build();
    }

    public static Role getUserRole(){
        return Role.builder()
                .id(ID)
                .roleName(USER)
                .build();
    }
    public static RoleResponse getRoleResponse(Role role){
        return RoleResponse.builder()
                .roleName(role.getRoleName())
                .build();
    }

    public static Set<Role> getRoles(){
        return Set.of(
                new Role(UUID.fromString("admin"), ADMIN),
                new Role(UUID.fromString("user"), USER));
    }


}
