package com.shubham.Daily_Expenses_Tracking_Application.Entity;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Enums.Role;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFullName;
    private String userEmail;
    private Long userMob;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "familyId")
    private Family family;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;


    @PrePersist
    public void createdAt() {
        createdAt = LocalDate.now();
    }
}
