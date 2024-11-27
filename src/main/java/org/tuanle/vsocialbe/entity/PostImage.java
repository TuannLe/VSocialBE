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

    @Embeddable
    public static class PostImageId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post postId;

        @Column(name = "image")
        private String image;

        public PostImageId() {}

        public PostImageId(Post postId, String image) {
            this.postId = postId;
            this.image = image;
        }

        public Post getPostId() {
            return postId;
        }

        public void setPostId(Post postId) {
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
