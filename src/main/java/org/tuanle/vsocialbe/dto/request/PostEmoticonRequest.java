package org.tuanle.vsocialbe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.enums.Emoticon;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostEmoticonRequest {
    String accountId;
    long postId;
    Emoticon emoticon;
}
