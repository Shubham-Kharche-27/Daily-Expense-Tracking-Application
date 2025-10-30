package com.shubham.Daily_Expenses_Tracking_Application.Dto;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Enums.ExpenseCategory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExpenseDto {
    private Double expenseAmount;
    private ExpenseCategory expenseCategory;
    private LocalDateTime expenseHappenAt;
    private UserDto user;
}
