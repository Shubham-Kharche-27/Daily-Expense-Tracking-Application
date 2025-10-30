package com.shubham.Daily_Expenses_Tracking_Application.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
