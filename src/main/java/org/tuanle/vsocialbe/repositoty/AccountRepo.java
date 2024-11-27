package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tuanle.vsocialbe.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    boolean existsByEmail(String email);
    Optional<Account> findByEmail(String email);
}
