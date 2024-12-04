package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostImage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(AddPostRequest request);

    @Mapping(source = "postImageList", target = "postImages")
    PostResponse toPostResponse(Post post);
    default List<String> mapPostImagesToUrls(List<PostImage> postImages) {
        if (postImages == null) {
            return Collections.emptyList(); // Handle null case
        }
        return postImages.stream()
                .map(postImage -> postImage.getPostImageId().getImage())
                .collect(Collectors.toList());
    }

    AccountResponse toAccountResponse(Account account);
}
