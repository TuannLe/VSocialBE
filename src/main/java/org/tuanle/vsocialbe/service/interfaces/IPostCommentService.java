package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.CommentRequest;
import org.tuanle.vsocialbe.dto.response.CommentResponse;

import java.util.List;

public interface IPostCommentService {
    String addComment(CommentRequest request);
    List<CommentResponse> getCommentByPostId(Long postId);
    CommentResponse editComment(int commentId, CommentRequest request);
    String deleteComment(int commentId);
}
