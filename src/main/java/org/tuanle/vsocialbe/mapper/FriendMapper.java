package org.tuanle.vsocialbe.mapper;

import org.mapstruct.Mapper;
import org.tuanle.vsocialbe.dto.request.FriendRequest;
import org.tuanle.vsocialbe.entity.Friend;

@Mapper(componentModel = "spring")
public interface FriendMapper {
    Friend toFriend(FriendRequest request);
}
