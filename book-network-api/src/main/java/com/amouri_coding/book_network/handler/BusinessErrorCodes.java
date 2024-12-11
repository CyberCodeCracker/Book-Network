package com.amouri_coding.book_network.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum BusinessErrorCodes {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST, "New password does not match"),
    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "Account locked"),
    ACCOUNT_DISABLED (303, HttpStatus.FORBIDDEN, "Account disabled"),
    BAD_CREDENTIALS(304, HttpStatus.FORBIDDEN, "Email and / or password is incorrect"),
    ;
    private final int code;
    private final HttpStatus httpStatus;
    private final String description;
}
