package com.shubham.Daily_Expenses_Tracking_Application.Dto;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private String userFullName;
    private String userEmail;
    private Long userMob;
    private Role role;
    private LocalDate createdAt;
}
