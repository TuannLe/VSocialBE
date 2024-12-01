package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "audience")
    private int audience;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImage> postImageList;

    public Post(long postId, String content, Account createdBy, LocalDateTime createdAt, int audience, int status, List<PostImage> postImageList) {
        this.postId = postId;
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.audience = audience;
        this.status = status;
        this.postImageList = postImageList;
    }
}
