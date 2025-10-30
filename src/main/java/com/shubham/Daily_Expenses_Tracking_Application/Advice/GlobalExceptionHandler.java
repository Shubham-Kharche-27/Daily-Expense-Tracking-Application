package com.shubham.Daily_Expenses_Tracking_Application.Advice;

import com.shubham.Daily_Expenses_Tracking_Application.Exception.ExpenseNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.FamilyNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.IncomeNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(UserNotFoundException ex){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(FamilyNotFoundException ex){
        return new ResponseEntity<>("Family not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(ExpenseNotFoundException ex){
        return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncomeNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(IncomeNotFoundException ex){
        return new ResponseEntity<>("Income not found", HttpStatus.NOT_FOUND);
    }

}
