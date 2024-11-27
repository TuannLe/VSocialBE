package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.PermissionRequest;
import org.tuanle.vsocialbe.dto.response.PermissionResponse;
import org.tuanle.vsocialbe.entity.Permission;
import org.tuanle.vsocialbe.mapper.PermissionMapper;
import org.tuanle.vsocialbe.repositoty.PermissionRepo;
import org.tuanle.vsocialbe.service.interfaces.IPermissionService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService implements IPermissionService {
    PermissionRepo permissionRepo;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse createPermission(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepo.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
        var permissions = permissionRepo.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void deletePermission(String permissionId) {
        permissionRepo.deleteById(permissionId);
    }
}
