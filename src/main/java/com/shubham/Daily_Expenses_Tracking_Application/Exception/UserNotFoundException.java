package com.shubham.Daily_Expenses_Tracking_Application.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
