package org.tuanle.vsocialbe.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.APIResponse;
import org.tuanle.vsocialbe.dto.response.PostReponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    @PostMapping
    public APIResponse<PostReponse> createPost(@RequestBody AddPostRequest request) {
        return null;
    }

    @GetMapping("/{postId}")
    public APIResponse<PostReponse> getPostById(@PathVariable String postId) {
        return null;
    }

    @GetMapping
    public APIResponse<List<PostReponse>> getAllPost() {
        return null;
    }

    @PostMapping("/{postId}")
    public APIResponse<PostReponse> updatePost(@PathVariable String postId, @RequestBody AddPostRequest request) {
        return null;
    }

    @DeleteMapping("{postId}")
    public APIResponse<String> deletePost(@PathVariable String postId) {
        return null;
    }
}
