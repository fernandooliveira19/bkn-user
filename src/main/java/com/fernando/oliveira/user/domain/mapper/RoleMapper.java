package com.fernando.oliveira.user.domain.mapper;

import com.fernando.oliveira.user.domain.entity.Role;
import com.fernando.oliveira.user.domain.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {UserMapper.class})
public interface RoleMapper {

    RoleResponse entityToRoleResponse(Role role);
}
