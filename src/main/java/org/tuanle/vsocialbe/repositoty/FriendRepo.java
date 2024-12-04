package org.tuanle.vsocialbe.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuanle.vsocialbe.entity.Friend;

public interface FriendRepo extends JpaRepository<Friend, Friend.FriendId> {
}
