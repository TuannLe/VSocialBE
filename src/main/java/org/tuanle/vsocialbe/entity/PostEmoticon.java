package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tuanle.vsocialbe.enums.Emoticon;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_post_emoticon")
@Getter
@Setter
public class PostEmoticon {
    @EmbeddedId
    private PostEmotionId postEmotionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "emoticon")
    private Emoticon emoticon;

    public PostEmoticon() {}

    public PostEmoticon(PostEmotionId postEmotionId, Post post, Emoticon emoticon) {
        this.postEmotionId = postEmotionId;
        this.post = post;
        this.emoticon = emoticon;
    }

    @Embeddable
    public static class PostEmotionId implements Serializable {
        @Column(name = "post_id")
        private long postId;

        @Column(name = "account_id")
        private String accountId;

        public PostEmotionId() {}

        public PostEmotionId(long postId, String accountId) {
            this.postId = postId;
            this.accountId = accountId;
        }

        public long getPostId() {
            return postId;
        }

        public void setPostId(long postId) {
            this.postId = postId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
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
