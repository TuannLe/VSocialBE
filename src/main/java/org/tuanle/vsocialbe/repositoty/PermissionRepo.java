package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tuanle.vsocialbe.entity.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, String> {

}
