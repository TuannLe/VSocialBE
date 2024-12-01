package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Post;

import java.util.List;

public interface IPostService {
    Post createPost(AddPostRequest request);
    PostResponse getPostById(String postId);
    List<PostResponse> getAllPost();
    PostResponse updatePost(String postId, AddPostRequest request);
    PostResponse deletePost(String postId);
}
