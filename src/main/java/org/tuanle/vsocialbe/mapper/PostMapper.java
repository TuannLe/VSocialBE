package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.tuanle.vsocialbe.dto.request.AddPostRequest;
import org.tuanle.vsocialbe.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toPost(AddPostRequest request);
}
