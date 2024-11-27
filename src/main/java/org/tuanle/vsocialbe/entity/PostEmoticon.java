package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_post_emoticon")
@Getter
@Setter
@NoArgsConstructor
public class PostEmoticon {
    @EmbeddedId
    private PostEmotionId postEmotionId;

    @Column(name = "emoticon")
    private int emoticon;

    @Embeddable
    public static class PostEmotionId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post postId;

        @ManyToOne
        @JoinColumn(name = "account_id")
        private Account accountId;

        public PostEmotionId() {}

        public PostEmotionId(Post postId, Account accountId) {
            this.postId = postId;
            this.accountId = accountId;
        }

        public Post getPostId() {
            return postId;
        }

        public void setPostId(Post postId) {
            this.postId = postId;
        }

        public Account getAccountId() {
            return accountId;
        }

        public void setAccountId(Account accountId) {
            this.accountId = accountId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PostEmotionId that = (PostEmotionId) o;
            return postId == that.postId && Objects.equals(accountId, that.accountId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(postId, accountId);
        }
    }
}
