package com.shubham.Daily_Expenses_Tracking_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;
    private String familyName;
    private Long totalFamilyMembers;
    private Double monthlyBudget;
    private LocalDate registeredAt;

    @OneToMany(mappedBy = "family")
    private List<User> users;

    @OneToMany(mappedBy = "families")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "familyIncome")
    private List<Income> incomes;

    @PrePersist
    public void registeredAt() {
        registeredAt = LocalDate.now();
    }
}
