package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuanle.vsocialbe.entity.Friend;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Friend.FriendId> {
//    List<Friend> findBySenderId(String senderId);
//    List<Friend> findByReceiverId(String receiverId);
}
