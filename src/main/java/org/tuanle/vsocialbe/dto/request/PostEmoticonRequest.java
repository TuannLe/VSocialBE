package org.tuanle.vsocialbe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostEmoticonRequest {
    String accountId;
    String postId;
    int emoticon;
}
