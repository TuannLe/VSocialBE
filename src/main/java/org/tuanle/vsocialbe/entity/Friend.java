package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tuanle.vsocialbe.enums.RelationshipStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_friend")
@Getter
@Setter
@NoArgsConstructor
public class Friend {
    @EmbeddedId
    private FriendId friendId;

    @Column(name = "status")
    private RelationshipStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Embeddable
    public static class FriendId implements Serializable {
        private String senderId;

        private String receiverId;

        public FriendId() {}

        public FriendId(String senderId, String receiverId) {
            this.senderId = senderId;
            this.receiverId = receiverId;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public String getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FriendId that = (FriendId) o;
            return senderId == that.senderId && Objects.equals(receiverId, that.receiverId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(senderId, receiverId);
        }
    }
}
