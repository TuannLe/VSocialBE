package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.FriendRequest;

import java.util.List;

public interface IFriendService {
    String addFriend(FriendRequest request);
    String acceptFriend(FriendRequest request);
    String unFriend(FriendRequest request);
    String blockFriend(FriendRequest request);
    List<String> getFriendsRequest();
}
