package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tuanle.vsocialbe.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {

}
