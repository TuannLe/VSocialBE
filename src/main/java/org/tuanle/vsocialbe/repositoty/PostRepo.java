package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tuanle.vsocialbe.entity.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, String> {
    @Query("SELECT p FROM Post p WHERE p.createdBy.accountId = :accountId ORDER BY p.createdAt DESC")
    List<Post> findPostsByAccountId(@Param("accountId") String accountId);

    @Query("SELECT p FROM Post p " +
            "JOIN Friend f ON (f.friendId.senderId = :accountId AND f.friendId.receiverId = p.createdBy.accountId) " +
            "OR (f.friendId.senderId = p.createdBy.accountId AND f.friendId.receiverId = :accountId) " +
            "WHERE f.status = 1 " +
            "AND p.audience = 1 " +
            "AND p.status = 1 " +
            "ORDER BY p.createdAt DESC")
    List<Post> findFriendPostsByAccountId(@Param("accountId") String accountId);
}
