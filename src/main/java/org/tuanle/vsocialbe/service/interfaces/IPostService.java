package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostReponse;

import java.util.List;

public interface IPostService {
    PostReponse createPost(AddPostRequest request);
    PostReponse getPostById(String postId);
    List<PostReponse> getAllPost();
    PostReponse updatePost(String postId, AddPostRequest request);
    PostReponse deletePost(String postId);
}
