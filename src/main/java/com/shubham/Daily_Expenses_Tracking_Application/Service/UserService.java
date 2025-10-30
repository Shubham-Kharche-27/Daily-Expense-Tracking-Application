package com.shubham.Daily_Expenses_Tracking_Application.Service;

import com.shubham.Daily_Expenses_Tracking_Application.Dto.UserDto;
import com.shubham.Daily_Expenses_Tracking_Application.Entity.User;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.UserNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUserData() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto getUserDataById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    public String createUserData(UserDto userDto){
         User user = modelMapper.map(userDto,User.class);
         userRepo.save(user);
         return "User data created successfully";
    }

    public String updateUserData(Long userId,UserDto userDto){
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        if(userDto.getUserFullName()!=null){
            user.setUserFullName(userDto.getUserFullName());
        }
        if(userDto.getUserEmail()!=null){
            user.setUserEmail(userDto.getUserEmail());
        }
        if(userDto.getUserMob()!=null){
            user.setUserMob(userDto.getUserMob());
        }
        if(userDto.getRole()!=null){
            user.setRole(userDto.getRole());
        }
        userRepo.save(user);
        return "User data updated successfully";
    }

    public String deleteUserData(Long userId){
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepo.deleteById(userId);
        return "User data deleted successfully";
    }
}
