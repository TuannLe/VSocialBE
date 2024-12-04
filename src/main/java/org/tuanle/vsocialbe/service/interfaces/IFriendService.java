package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.FriendRequest;

import java.util.List;

public interface IFriendService {
    String addFriend(FriendRequest request);
    String acceptFriend(FriendRequest friendId);
    String unFriend(FriendRequest friendId);
    String blockFriend(FriendRequest friendId);
    List<String> getFriendsRequest();
}
