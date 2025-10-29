package com.shubham.Daily_Expenses_Tracking_Application.Entity;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFullName;
    private String userEmail;
    private Long userMob;
    private Role role;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "userIncome")
    private List<Income> incomes;

    @PrePersist
    public void createdAt() {
        createdAt = LocalDate.now();
    }
}
