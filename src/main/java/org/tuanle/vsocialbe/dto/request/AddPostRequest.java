package org.tuanle.vsocialbe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPostRequest {
    String content;
    String accountId;
    int audience;
    MultipartFile images;
}
