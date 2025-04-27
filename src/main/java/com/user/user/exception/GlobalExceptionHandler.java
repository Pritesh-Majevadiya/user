package com.user.user.exception;

import com.common_service.model.common.CommonError;
import com.common_service.model.common.CommonResponse;
import com.user.user.exception.custom.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.error("Resource not found exception: {}", ex.getMessage(), ex);

        CommonError error = new CommonError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        CommonResponse response = new CommonResponse(
                HttpStatus.NOT_FOUND.value(),
                "Resource not found",
                Collections.singletonList(error)
        );
        response.setPath(getPathFromRequest(request));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Validation error: {}", ex.getMessage(), ex);

        List<CommonError> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new CommonError(error.getField() + " : " + error.getDefaultMessage(), HttpStatus.BAD_REQUEST.value()))
                .collect(Collectors.toList());

        CommonResponse response = new CommonResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors
        );
        response.setPath(getPathFromRequest(request));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);

        CommonError error = new CommonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        CommonResponse response = new CommonResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred",
                Collections.singletonList(error)
        );
        response.setPath(getPathFromRequest(request));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getPathFromRequest(WebRequest request) {
        // remove "uri=" from WebRequest description
        String description = request.getDescription(false);
        return description.replace("uri=", "");
    }
}
