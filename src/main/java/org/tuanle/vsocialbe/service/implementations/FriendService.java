package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.FriendRequest;
import org.tuanle.vsocialbe.dto.response.AccountFriendResponse;
import org.tuanle.vsocialbe.entity.Friend;
import org.tuanle.vsocialbe.enums.RelationshipStatus;
import org.tuanle.vsocialbe.exception.AppException;
import org.tuanle.vsocialbe.exception.ErrorCode;
import org.tuanle.vsocialbe.mapper.FriendMapper;
import org.tuanle.vsocialbe.repositoty.FriendRepo;
import org.tuanle.vsocialbe.service.interfaces.IFriendService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendService implements IFriendService {
    FriendRepo friendRepo;

    @Override
    public String addFriend(FriendRequest request) {
        Friend friend = new Friend();
        friend.setCreatedAt(LocalDateTime.now());
        friend.setStatus(RelationshipStatus.REQUEST);
        Friend.FriendId friendId = new Friend.FriendId(request.getSenderId(), request.getReceiverId());
        friend.setFriendId(friendId);
        friendRepo.save(friend);
        return "Add friend successfully";
    }

    @Override
    public String acceptFriend(FriendRequest request) {
        Friend.FriendId friendId = new Friend.FriendId(request.getSenderId(), request.getReceiverId());
        Friend friend = friendRepo.findById(friendId).orElseThrow(() -> new AppException(ErrorCode.FRIEND_NOT_EXISTED));
        friend.setStatus(RelationshipStatus.FRIEND);
        friendRepo.save(friend);
        return "Accept friend successfully";
    }

    @Override
    public String unFriend(FriendRequest request) {
        Friend.FriendId friendId = new Friend.FriendId(request.getSenderId(), request.getReceiverId());
        Friend friend = friendRepo.findById(friendId).orElseThrow(() -> new AppException(ErrorCode.FRIEND_NOT_EXISTED));
        friendRepo.delete(friend);
        return "Unfriend friend successfully";
    }

    @Override
    public String blockFriend(FriendRequest request) {
        Friend.FriendId friendId = new Friend.FriendId(request.getSenderId(), request.getReceiverId());
        Friend friend = friendRepo.findById(friendId).orElseThrow(() -> new AppException(ErrorCode.FRIEND_NOT_EXISTED));
        friend.setStatus(RelationshipStatus.BLOCK);
        friendRepo.save(friend);
        return "Block friend successfully";
    }

    @Override
    public List<AccountFriendResponse> getFriendsRequest(String accountId) {
        return friendRepo.getFriendRequests(accountId);
    }
}
