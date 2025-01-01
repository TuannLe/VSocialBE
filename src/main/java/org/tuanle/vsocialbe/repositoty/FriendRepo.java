package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tuanle.vsocialbe.dto.response.AccountFriendResponse;
import org.tuanle.vsocialbe.entity.Friend;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Friend.FriendId> {
    @Query("SELECT new org.tuanle.vsocialbe.dto.response.AccountFriendResponse(a.accountId, a.email, a.username, a.avatar, f.status) " +
            "FROM Account a " +
            "LEFT JOIN Friend f " +
            "ON (f.friendId.senderId = a.accountId AND f.friendId.receiverId = :accountId) " +
            "WHERE f.status = 0")
    List<AccountFriendResponse> getFriendRequests(@Param("accountId") String accountId);
}
