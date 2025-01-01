package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tuanle.vsocialbe.dto.response.AccountFriendResponse;
import org.tuanle.vsocialbe.entity.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    boolean existsByEmail(String email);
    Optional<Account> findByEmail(String email);
//    @Query(value = "SELECT * FROM tbl_movie m WHERE m.description  LIKE %:keyword% OR m.title LIKE %:keyword%", nativeQuery = true)
    @Query("SELECT a FROM Account a WHERE " +
            "LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(a.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Account> searchAccounts(String keyword);

    @Query("SELECT new org.tuanle.vsocialbe.dto.response.AccountFriendResponse(a.accountId, a.email, a.username, a.avatar, " +
            "COALESCE(f.status, '3')) " +
            "FROM Account a LEFT JOIN Friend f " +
            "ON (f.friendId.senderId = :accountId AND f.friendId.receiverId = a.accountId) " +
            "OR (f.friendId.senderId = a.accountId AND f.friendId.receiverId = :accountId) " +
            "WHERE (:keyword IS NULL OR a.email LIKE %:keyword% " +
            "OR a.username LIKE %:keyword%)")
    List<AccountFriendResponse> findAllAccountsWithFriendStatusByKeyword(
            @Param("accountId") String accountId,
            @Param("keyword") String keyword);
}
