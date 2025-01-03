package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostResponse;

import java.util.List;

public interface IPostService {
    PostResponse createPost(AddPostRequest request);
    PostResponse getPostById(String postId);
    List<PostResponse> getAllPost();
    List<PostResponse> getPostByAccountId(String accountId);
    List<PostResponse> getPostFriendByAccountId(String accountId);
    PostResponse updatePost(String postId, AddPostRequest request);
    String deletePost(String postId);
}
