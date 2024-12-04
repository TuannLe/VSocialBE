package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.repositoty.PostRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    IPostService postService;
    private final PostRepo postRepo;

    @PostMapping
    public APIResponse<PostResponse> createPost(@ModelAttribute AddPostRequest request) {
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

    @GetMapping("/all")
    public APIResponse<List<PostResponse>> getAllPost() {
        return APIResponse.<List<PostResponse>>builder()
                .result(postService.getAllPost())
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
