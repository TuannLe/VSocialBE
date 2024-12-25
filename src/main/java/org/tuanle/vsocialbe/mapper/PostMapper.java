package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.dto.request.PostEmoticonRequest;
import org.tuanle.vsocialbe.dto.response.AccountResponse;
import org.tuanle.vsocialbe.dto.response.PostResponse;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostEmoticon;
import org.tuanle.vsocialbe.entity.PostImage;
import org.tuanle.vsocialbe.enums.Emoticon;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toPost(AddPostRequest request);

    Post toPost(PostEmoticonRequest request);

    @Mapping(source = "postImageList", target = "postImages")
    @Mapping(source = "postEmoticonList", target = "emoticons")
    PostResponse toPostResponse(Post post);

    default List<String> mapPostImagesToUrls(List<PostImage> postImages) {
        if (postImages == null) {
            return Collections.emptyList();
        }
        return postImages.stream()
                .map(postImage -> postImage.getPostImageId().getImage())
                .collect(Collectors.toList());
    }

    default List<Emoticon> mapEmoticonsToEmoticon(List<PostEmoticon> postEmoticons) {
        if (postEmoticons == null) {
            return Collections.emptyList();
        }
        return postEmoticons.stream()
                .map(PostEmoticon::getEmoticon)
                .toList();
    }

    AccountResponse toAccountResponse(Account account);

}
