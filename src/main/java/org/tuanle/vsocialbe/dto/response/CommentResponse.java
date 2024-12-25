package org.tuanle.vsocialbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.enums.CommentStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {
    int commentId;
    String comment;
    LocalDateTime createdAt;
    Account createdBy;
    long postId;
    CommentStatus status;
}
