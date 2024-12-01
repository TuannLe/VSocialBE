package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
}
