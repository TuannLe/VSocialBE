package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.PermissionRequest;
import org.tuanle.vsocialbe.dto.response.PermissionResponse;

import java.util.List;

public interface IPermissionService {
    PermissionResponse createPermission(PermissionRequest request);
    List<PermissionResponse> getAllPermissions();
    void deletePermission(String permissionId);
}
