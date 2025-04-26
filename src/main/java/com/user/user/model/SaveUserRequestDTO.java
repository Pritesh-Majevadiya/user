package com.user.user.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequestDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String personalMail;
    private String primaryMobileNo;
    private String secondaryMobileNo;
    //Todo: add save Address requestDTO
    private Long addId;

    public boolean checkBadRequest(){
        return StringUtils.isAllEmpty(this.getFirstName(), this.getPersonalMail(), this.getPrimaryMobileNo());
    }
}


