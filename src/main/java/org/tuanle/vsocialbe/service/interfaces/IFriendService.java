package org.tuanle.vsocialbe.service.interfaces;

import org.tuanle.vsocialbe.dto.request.FriendRequest;
import org.tuanle.vsocialbe.dto.response.AccountFriendResponse;

import java.util.List;

public interface IFriendService {
    String addFriend(FriendRequest request);
    String acceptFriend(FriendRequest request);
    String unFriend(FriendRequest request);
    String blockFriend(FriendRequest request);
    List<AccountFriendResponse> getFriendsRequest(String accountId);
}
