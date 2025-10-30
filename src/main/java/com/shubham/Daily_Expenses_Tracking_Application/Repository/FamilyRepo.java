package com.shubham.Daily_Expenses_Tracking_Application.Repository;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family,Long> {
}
