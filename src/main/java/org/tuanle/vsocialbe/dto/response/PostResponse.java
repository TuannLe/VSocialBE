package org.tuanle.vsocialbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.enums.Emoticon;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    long postId;
    String content;
    AccountResponse createdBy;
    LocalDateTime createdAt;
    int audience;
    List<String> postImages;
    List<Emoticon> emoticons;
}
