package com.shubham.Daily_Expenses_Tracking_Application.Controller;

import com.shubham.Daily_Expenses_Tracking_Application.Dto.UserDto;
import com.shubham.Daily_Expenses_Tracking_Application.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUserData(), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserDataById(userId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUserData(userDto),HttpStatus.OK);
    }

    @PutMapping("/put/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUserData(userId,userDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.deleteUserData(userId),HttpStatus.OK);
    }
}
