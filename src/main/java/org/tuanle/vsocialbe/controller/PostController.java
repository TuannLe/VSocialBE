package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.service.interfaces.IPostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    IPostService postService;

    @PostMapping
    public APIResponse<Post> createPost(@ModelAttribute AddPostRequest request) {
        return APIResponse.<Post>builder()
                .result(postService.createPost(request))
                .build();
    }

    @GetMapping("/{postId}")
    public APIResponse<PostResponse> getPostById(@PathVariable String postId) {
        return null;
    }

    @GetMapping
    public APIResponse<List<PostResponse>> getAllPost() {
        return null;
    }

    @PostMapping("/{postId}")
    public APIResponse<PostResponse> updatePost(@PathVariable String postId, @RequestBody AddPostRequest request) {
        return null;
    }

    @DeleteMapping("{postId}")
    public APIResponse<String> deletePost(@PathVariable String postId) {
        return null;
    }
}
