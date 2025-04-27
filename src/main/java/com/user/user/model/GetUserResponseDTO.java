package com.user.user.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponseDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String personalMail;
    private String primaryMobileNo;
    private String secondaryMobileNo;

}
