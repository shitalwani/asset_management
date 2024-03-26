package com.asset_management.asset.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {
    private final String message;

    private final Integer statusCode;

    private final String statusName;
}
