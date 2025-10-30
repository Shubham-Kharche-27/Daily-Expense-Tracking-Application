package com.shubham.Daily_Expenses_Tracking_Application.Exception;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
