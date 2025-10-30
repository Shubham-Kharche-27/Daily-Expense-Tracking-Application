package com.shubham.Daily_Expenses_Tracking_Application.Repository;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense,Long> {
}
