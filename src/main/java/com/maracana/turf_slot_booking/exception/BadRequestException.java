package com.maracana.turf_slot_booking.exception;

public class BadRequestException extends RuntimeException {
    private final String errorCode;

    // Constructor for message only
    public BadRequestException(String message) {
        super(message);
        this.errorCode = "BAD_REQUEST"; // Default error code
    }

    // Constructor for message and error code
    public BadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Constructor for message and cause
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "BAD_REQUEST";
    }

    public String getErrorCode() {
        return errorCode;
    }
}
