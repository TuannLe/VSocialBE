package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.RoleRequest;
import org.tuanle.vsocialbe.dto.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    RoleResponse createRole(RoleRequest request);
    List<RoleResponse> getAllRoles();
    void deleteRole(String roleId);
}
