package org.tuanle.vsocialbe.service.implementations;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.tuanle.vsocialbe.dto.request.FriendRequest;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.entity.Friend;
import org.tuanle.vsocialbe.enums.RelationshipStatus;
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
    FriendMapper friendMapper;

    @Override
    public String addFriend(FriendRequest request) {
        Friend friend = new Friend();
        friend.setCreatedAt(LocalDateTime.now());
        friend.setStatus(RelationshipStatus.FRIEND);
        Friend.FriendId friendId = new Friend.FriendId(request.getSenderId(), request.getReceiverId());
        friend.setFriendId(friendId);
        friendRepo.save(friend);
        return "Add friend successfully";
    }

    @Override
    public String acceptFriend(FriendRequest friendId) {
        return "";
    }

    @Override
    public String unFriend(FriendRequest friendId) {
        return "";
    }

    @Override
    public String blockFriend(FriendRequest friendId) {
        return "";
    }

    @Override
    public List<String> getFriendsRequest() {
        return List.of();
    }
}
