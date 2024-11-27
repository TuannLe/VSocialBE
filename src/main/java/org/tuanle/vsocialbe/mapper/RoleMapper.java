package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tuanle.vsocialbe.dto.request.RoleRequest;
import org.tuanle.vsocialbe.dto.response.RoleResponse;
import org.tuanle.vsocialbe.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
