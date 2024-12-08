package com.amouri_coding.book_network.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum BusinessErrorCodes {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(100, HttpStatus.BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(101, HttpStatus.BAD_REQUEST, "New password does not match"),
    ACCOUNT_LOCKED(102, HttpStatus.FORBIDDEN, "Account locked"),
    ACCOUNT_DISABLED (103, HttpStatus.FORBIDDEN, "Account disabled"),
    BAD_CREDENTIALS(104, HttpStatus.FORBIDDEN, "Email and / or password is incorrect"),
    ;
    private final int code;
    private final HttpStatus httpStatus;
    private final String description;
}
