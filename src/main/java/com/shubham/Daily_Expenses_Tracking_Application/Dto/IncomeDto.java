package com.shubham.Daily_Expenses_Tracking_Application.Dto;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Family;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IncomeDto {
    private String incomeSource;
    private Double amount;
    private LocalDate incomeReceivedAt;
    private Family familyIncome;
}
