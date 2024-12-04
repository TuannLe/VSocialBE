package org.tuanle.vsocialbe.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    KEY_INVALID(999, "Key is invalid", HttpStatus.INTERNAL_SERVER_ERROR),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1000, "Email already in use", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1001, "Password must contain at least one digit, one lowercase letter, " +
            "one uppercase letter, one special character, and be at least 8 characters long.", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(1002, "Email should be valid", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_EXISTED(1004, "Email not existed.", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1005, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006, "You do not have permission", HttpStatus.FORBIDDEN),
    DOB_INVALID(1007, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    CREATE_POST_FAIL(1008, "Create post failure", HttpStatus.BAD_REQUEST),
    POST_NOT_EXISTED(1009, "Post not existed.", HttpStatus.NOT_FOUND),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
