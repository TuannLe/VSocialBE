package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tuanle.vsocialbe.entity.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, String> {
    @Query("SELECT p FROM Post p WHERE p.createdBy.accountId = :accountId")
    List<Post> findPostsByAccountId(@Param("accountId") String accountId);
}
