package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.CommentRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.CommentResponse;
import org.tuanle.vsocialbe.service.interfaces.IPostCommentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostCommentController {
    IPostCommentService postCommentService;

    @PostMapping
    public APIResponse<String> createComment(@RequestBody CommentRequest request) {
        return APIResponse.<String>builder()
                .result(postCommentService.addComment(request))
                .build();
    }

    @GetMapping("/{postId}")
    public APIResponse<List<CommentResponse>> getComment(@PathVariable long postId) {
        return APIResponse.<List<CommentResponse>>builder()
                .result(postCommentService.getCommentByPostId(postId))
                .build();
    }

    @PutMapping("/{commentId}")
    public APIResponse<CommentResponse> updateComment(@PathVariable int commentId, @RequestBody CommentRequest request) {
        return APIResponse.<CommentResponse>builder()
                .result(postCommentService.editComment(commentId, request))
                .build();
    }

    @DeleteMapping("/{commentId}")
    public APIResponse<String> deleteComment(@PathVariable int commentId) {
        return APIResponse.<String>builder()
                .result(postCommentService.deleteComment(commentId))
                .build();
    }

}
