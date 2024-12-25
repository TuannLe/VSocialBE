package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tuanle.vsocialbe.enums.CommentStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_post_comment")
@Getter
@Setter
@NoArgsConstructor
public class PostComment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account createdBy;

    @ManyToOne
    @JoinColumn(name ="post_id")
    private Post postId;

    @Column(name = "status")
    private CommentStatus status;
}
