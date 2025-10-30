package com.shubham.Daily_Expenses_Tracking_Application.Repository;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income,Long> {
}
