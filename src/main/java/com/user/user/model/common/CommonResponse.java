package com.user.user.model.common;

import com.user.user.model.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private int status;
    private String message;
    private Object data;
    private List<Error> error;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public CommonResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CommonResponse(int status, String message, List<Error> error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
