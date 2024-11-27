package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Embeddable
    public static class FriendId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "sender_id")
        private Account senderId;

        @ManyToOne
        @JoinColumn(name = "receiver_id")
        private Account receiverId;

        public FriendId() {}

        public FriendId(Account senderId, Account receiverId) {
            this.senderId = senderId;
            this.receiverId = receiverId;
        }

        public Account getSenderId() {
            return senderId;
        }

        public void setSenderId(Account senderId) {
            this.senderId = senderId;
        }

        public Account getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(Account receiverId) {
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
