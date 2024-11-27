package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.RoleRequest;
import org.tuanle.vsocialbe.dto.response.RoleResponse;
import org.tuanle.vsocialbe.mapper.RoleMapper;
import org.tuanle.vsocialbe.repositoty.PermissionRepo;
import org.tuanle.vsocialbe.repositoty.RoleRepo;
import org.tuanle.vsocialbe.service.interfaces.IRoleService;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService implements IRoleService {
    RoleRepo roleRepo;
    RoleMapper roleMapper;
    PermissionRepo permissionRepo;

    @Override
    public RoleResponse createRole(RoleRequest request) {
        var role = roleMapper.toRole(request);
        var permissions = permissionRepo.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        roleRepo.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepo.findAll()
                .stream()
                .map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public void deleteRole(String roleId) {
        roleRepo.deleteById(roleId);
    }
}
