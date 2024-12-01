package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_post_image")
@Getter
@Setter
@NoArgsConstructor
public class PostImage {
    @EmbeddedId
    private PostImageId postImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    public PostImage(PostImageId postImageId, Post post) {
        this.postImageId = postImageId;
        this.post = post;
    }

    @Embeddable
    public static class PostImageId implements Serializable {
        @Column(name = "post_id")
        private long postId;

        @Column(name = "image")
        private String image;

        public PostImageId() {}

        public PostImageId(long postId, String image) {
            this.postId = postId;
            this.image = image;
        }

        public long getPostId() {
            return postId;
        }

        public void setPostId(long postId) {
            this.postId = postId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PostImageId that = (PostImageId) o;
            return postId == that.postId && Objects.equals(image, that.image);
        }

        @Override
        public int hashCode() {
            return Objects.hash(postId, image);
        }
    }
}
