package com.bridgelabz.addressbookapp.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;     // Changed from 'message' to 'error' for error type/title
    private String details;   // Detailed message, e.g. validation or exception message

    public ErrorResponse(LocalDateTime timestamp, String error, String details) {
        this.timestamp = timestamp;
        this.error = error;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getDetails() {
        return details;
    }
}
