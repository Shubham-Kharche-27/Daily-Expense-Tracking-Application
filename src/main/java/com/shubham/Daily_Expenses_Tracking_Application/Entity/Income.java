package com.shubham.Daily_Expenses_Tracking_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String incomeSource;
    private Double amount;
    private LocalDate incomeReceivedAt;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family familyIncome;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userIncome;
}
