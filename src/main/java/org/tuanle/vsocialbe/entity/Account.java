package org.tuanle.vsocialbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.tuanle.vsocialbe.validator.DobConstraint;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbl_account")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String accountId;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "user_name")
    String username;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "cover_photo")
    String coverPhoto;

    @Column(name = "address")
    String address;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "dob")
    LocalDate dateOfBirth;

    @Column(name = "otp")
    int otp;

    @Column(name = "status")
    int status;

    @Column(name = "role")
    @ManyToMany
    Set<Role> roles;

//    @OneToMany(mappedBy = "senderId", cascade = CascadeType.ALL)
//    private Set<Friend> friendsRequested;
//
//    @OneToMany(mappedBy = "receiverId", cascade = CascadeType.ALL)
//    private Set<Friend> friendsReceived;
}
