package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.tuanle.vsocialbe.dto.request.CommentRequest;
import org.tuanle.vsocialbe.dto.response.CommentResponse;
import org.tuanle.vsocialbe.entity.Post;
import org.tuanle.vsocialbe.entity.PostComment;

@Mapper(componentModel = "spring")
public interface PostCommentMapper {
//    @Mapping(target = "postId", source = "postId", qualifiedByName = "mapPostId")
//    PostComment toPostComment(CommentRequest request);
//
//    @Named("mapPostId")
//    default PostComment mapPostId(Long postId) {
//        if (postId == null) return null;
//        PostComment postComment = new PostComment();
//        Post post = new Post();
//        post.setPostId(postId);
//        postComment.setPostId(post);
//        return postComment;
//    }
//\

    PostCommentMapper INSTANCE = Mappers.getMapper(PostCommentMapper.class);

    @Mapping(source = "postId.postId", target = "postId")
    CommentResponse toCommentResponse(PostComment postComment);

}
