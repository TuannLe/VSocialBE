package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuanle.vsocialbe.entity.Post;

public interface PostRepo extends JpaRepository<Post, String> {
}
