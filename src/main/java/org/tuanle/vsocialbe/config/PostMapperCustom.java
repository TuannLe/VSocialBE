package org.tuanle.vsocialbe.config;

import org.springframework.stereotype.Component;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Post;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class PostMapperCustom {
    public PostResponse toPostResponse(Post post) {
        PostResponse response = new PostResponse();
        response.setPostId(post.getPostId());
        response.setContent(post.getContent());
        response.setPostImages(post.getPostImageList() == null
                ? Collections.emptyList()
                : post.getPostImageList()
                    .stream()
                    .map(postImage -> postImage.getPostImageId().getImage())
                    .collect(Collectors.toList()));
        return response;
    }
}
