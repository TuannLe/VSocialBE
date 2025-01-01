package org.tuanle.vsocialbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.enums.RelationshipStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountFriendResponse {
    String accountId;
    String email;
    String username;
    String avatar;
    RelationshipStatus status;
}
