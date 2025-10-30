package com.shubham.Daily_Expenses_Tracking_Application.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FamilyDto {
    private String familyName;
    private Long totalFamilyMembers;
    private Double monthlyBudget;
    private LocalDate registeredAt;
    private List<ExpenseDto> expenses;
    private List<UserDto> users;
}
