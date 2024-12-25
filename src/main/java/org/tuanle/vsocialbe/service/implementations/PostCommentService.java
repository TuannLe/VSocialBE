package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.CommentRequest;
import org.tuanle.vsocialbe.dto.response.CommentResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostComment;
import org.tuanle.vsocialbe.enums.CommentStatus;
import org.tuanle.vsocialbe.mapper.PostCommentMapper;
import org.tuanle.vsocialbe.repositoty.PostCommentRepo;
import org.tuanle.vsocialbe.repositoty.PostRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostCommentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostCommentService implements IPostCommentService {
    PostCommentRepo postCommentRepo;
    PostCommentMapper postCommentMapper;

    @Override
    public String addComment(CommentRequest request) {
//        PostComment postComment = postCommentMapper.toPostComment(request);
//        return postCommentMapper.toCommentResponse(postCommentRepo.save(postComment));
        Post post = new Post();
        post.setPostId(request.getPostId());
        Account account = new Account();
        account.setAccountId(request.getAccountId());

        PostComment postComment = new PostComment();
        postComment.setPostId(post);
        postComment.setComment(request.getComment());
        postComment.setStatus(CommentStatus.ACTIVE);
        postComment.setCreatedBy(account);
        postComment.setCreatedAt(LocalDateTime.now());
        postCommentRepo.save(postComment);
        return "Create comment success";
    }

    @Override
    public List<CommentResponse> getCommentByPostId(Long postId) {
        Post post = new Post();
        post.setPostId(postId);
        List<PostComment> comments = postCommentRepo.findByPostId(post);
        return comments.stream()
                .map(PostCommentMapper.INSTANCE::toCommentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CommentResponse editComment(int commentId, CommentRequest request) {
        return null;
    }

    @Override
    public String deleteComment(int commentId) {
        return "";
    }
}
