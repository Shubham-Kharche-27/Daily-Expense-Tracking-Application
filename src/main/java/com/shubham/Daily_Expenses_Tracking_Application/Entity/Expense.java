package com.shubham.Daily_Expenses_Tracking_Application.Entity;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Enums.ExpenseCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private Double expenseAmount;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;

    private LocalDateTime expenseHappenAt;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family families;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    public void happenAt() {
        expenseHappenAt = LocalDateTime.now();
    }
}
