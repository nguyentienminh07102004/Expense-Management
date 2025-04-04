package com.b22cn539.expense_management.Common.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum AppException {
    USER_NOT_FOUND(404, "User don't found!", HttpStatus.NOT_FOUND),

    TOKEN_INVALID(401, "Token is invalid!", HttpStatus.UNAUTHORIZED),
    ;

    private final Integer status;
    private final String message;
    private final HttpStatus httpStatus;
}
