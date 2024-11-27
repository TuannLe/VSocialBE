package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.tuanle.vsocialbe.dto.request.PermissionRequest;
import org.tuanle.vsocialbe.dto.response.PermissionResponse;
import org.tuanle.vsocialbe.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
