package com.fernando.oliveira.user.domain.mapper;

import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.request.CreateUserRequest;
import com.fernando.oliveira.user.domain.response.UserRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {RoleMapper.class})
public interface UserMapper {

    User createUserRequestToEntity(CreateUserRequest request);

    UserDetailResponse entityToResponse(User user);

    UserRoleResponse entityToUserRoleResponse(User user);
}
