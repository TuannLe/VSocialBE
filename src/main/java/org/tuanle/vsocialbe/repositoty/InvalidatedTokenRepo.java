package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tuanle.vsocialbe.entity.InvalidatedToken;

@Repository
public interface InvalidatedTokenRepo extends JpaRepository<InvalidatedToken, String> {
}
