package com.b22cn539.expense_management.Common.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum AppException {
    USER_NOT_FOUND(404, "User don't found!", HttpStatus.NOT_FOUND),
    USER_ACCOUNT_LOCKED(409, "User is locked!", HttpStatus.CONFLICT),
    USER_ACCOUNT_LOGIN_MAX_DEVICE(409, "Account login in max device!", HttpStatus.CONFLICT),

    TOKEN_INVALID(401, "Token is invalid!", HttpStatus.UNAUTHORIZED),

    PASSWORD_LENGTH_NOT_CORRECT(400, "Password length must be longer 8 characters!", HttpStatus.BAD_REQUEST),
    PASSWORD_CONFIRM_PASSWORD_NOT_MATCH(400, "Password confirmation password does not match!", HttpStatus.BAD_REQUEST),

    FULL_NAME_NOT_NULL(400, "Full name cannot be null!", HttpStatus.BAD_REQUEST),

    EMAIL_INVALID(400, "Email is invalid!", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS(400, "Email already exists!", HttpStatus.BAD_REQUEST),
    EMAIL_OR_PASSWORD_NOT_CORRECT(400, "Email or username is invalid!", HttpStatus.BAD_REQUEST),

    ROLE_NOT_FOUND(404, "Role not found!", HttpStatus.NOT_FOUND),

    SERVER_ERROR(500, "Server error!", HttpStatus.INTERNAL_SERVER_ERROR);
    ;

    private final Integer status;
    private final String message;
    private final HttpStatus httpStatus;
}
