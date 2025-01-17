package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.service.interfaces.IPostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    IPostService postService;

    @PostMapping
    public APIResponse<PostResponse> createPost(@ModelAttribute AddPostRequest request) {
        System.out.println(request.getContent());
        System.out.println(request.getAccountId());
        return APIResponse.<PostResponse>builder()
                .result(postService.createPost(request))
                .build();
    }

    @GetMapping("/{postId}")
    public APIResponse<PostResponse> getPostById(@PathVariable String postId) {
        return APIResponse.<PostResponse>builder()
                .result(postService.getPostById(postId))
                .build();
    }

    @GetMapping()
    public APIResponse<List<PostResponse>> getAllPost() {
        return APIResponse.<List<PostResponse>>builder()
                .result(postService.getAllPost())
                .build();
    }

    @GetMapping("/acc/{accountId}")
    public APIResponse<List<PostResponse>> getPostByUserID(@PathVariable String accountId) {
        return APIResponse.<List<PostResponse>>builder()
                .result(postService.getPostByAccountId(accountId))
                .build();
    }

    @GetMapping("/friend/{accountId}")
    public APIResponse<List<PostResponse>> getPostFriendByUserID(@PathVariable String accountId) {
        return APIResponse.<List<PostResponse>>builder()
                .result(postService.getPostFriendByAccountId(accountId))
                .build();
    }

    @PostMapping("/{postId}")
    public APIResponse<PostResponse> updatePost(@PathVariable String postId, @RequestBody AddPostRequest request) {
        return null;
    }

    @DeleteMapping("{postId}")
    public APIResponse<String> deletePost(@PathVariable String postId) {
        return APIResponse.<String>builder()
                .result(postService.deletePost(postId))
                .build();
    }
}
