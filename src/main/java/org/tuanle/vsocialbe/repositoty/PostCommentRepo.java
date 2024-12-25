package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuanle.vsocialbe.dto.response.CommentResponse;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostComment;

import java.util.List;

public interface PostCommentRepo extends JpaRepository<PostComment, Long> {
    List<PostComment> findByPostId(Post postId);
}
