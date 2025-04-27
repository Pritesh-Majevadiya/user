package com.user.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserRequestDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String personalMail;
    private String primaryMobileNo;
    private String secondaryMobileNo;
    private Long addId;
    private Integer pageSize;
    private Integer pageIndex;
    private Date startDate;
    private Date endDate;

    public boolean checkBadRequest(){
        return ObjectUtils.isEmpty(this.getPageIndex()) || ObjectUtils.isEmpty(this.getPageSize())
                ||  ObjectUtils.isEmpty(this.getStartDate()) || ObjectUtils.isEmpty(this.getEndDate());
    }
}
