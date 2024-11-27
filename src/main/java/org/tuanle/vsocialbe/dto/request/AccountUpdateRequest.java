package org.tuanle.vsocialbe.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.validator.DobConstraint;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountUpdateRequest {
    String username;
    String avatar;
    String coverPhoto;
    String address;
    String phoneNumber;

    @DobConstraint(min = 10, message =  "DOB_INVALID")
    LocalDate dateOfBirth;

    List<String> roles;
}
