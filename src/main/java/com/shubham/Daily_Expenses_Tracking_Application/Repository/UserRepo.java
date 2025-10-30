package com.shubham.Daily_Expenses_Tracking_Application.Repository;

import com.shubham.Daily_Expenses_Tracking_Application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
