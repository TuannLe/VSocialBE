package org.tuanle.vsocialbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    String accountId;
    String email;
    String username;
    String avatar;
    String coverPhoto;
    String address;
    String phoneNumber;
    LocalDate dateOfBirth;
    Set<RoleResponse> roles;
}
