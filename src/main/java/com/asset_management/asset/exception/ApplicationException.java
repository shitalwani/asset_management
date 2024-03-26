package com.asset_management.asset.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
    private final String message;
    private final Integer errorCode;
    private final HttpStatus httpStatus;
}
