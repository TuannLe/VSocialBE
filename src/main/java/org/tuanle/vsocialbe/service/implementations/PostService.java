package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.PostReponse;
import org.tuanle.vsocialbe.mapper.PostMapper;
import org.tuanle.vsocialbe.repositoty.PostRepo;
import org.tuanle.vsocialbe.service.interfaces.IPostService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostService implements IPostService {
    PostRepo postRepo;
    PostMapper postMapper;

    @Override
    public PostReponse createPost(AddPostRequest request) {
//        Post post = postMapper.toPost(request);
//        return postRepo.save(post);
        return null;
    }

    @Override
    public PostReponse getPostById(String postId) {
        return null;
    }

    @Override
    public List<PostReponse> getAllPost() {
        return List.of();
    }

    @Override
    public PostReponse updatePost(String postId, AddPostRequest request) {
        return null;
    }

    @Override
    public PostReponse deletePost(String postId) {
        return null;
    }
}
