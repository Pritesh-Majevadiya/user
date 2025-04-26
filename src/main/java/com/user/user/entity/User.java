package com.user.user.entity;

import com.user.user.entity.common.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="user_master")
public class User extends CommonEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "personal_mail")
    private String personalMail;

    @Column(name = "primary_mobile_no")
    private String primaryMobileNo;

    @Column(name = "secondary_mobile_no")
    private String secondaryMobileNo;

    @Column(name = "add_id")
    private Long addId;
}
