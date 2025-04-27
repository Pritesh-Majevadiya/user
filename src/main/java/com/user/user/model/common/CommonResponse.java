package com.user.user.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private int status;
    private String message;
    private Object data;
    private List<CommonError> commonError;
    private LocalDateTime timestamp;
    private String path;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public CommonResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public CommonResponse(int status, String message, List<CommonError> commonError) {
        this.status = status;
        this.message = message;
        this.commonError = commonError;
        this.timestamp = LocalDateTime.now();
    }
}
