package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_group_message")
@Getter
@Setter
@NoArgsConstructor
public class GroupMessage {
    @Id
    @Column(name = "group_message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupMessageId;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account createdBy;
}
