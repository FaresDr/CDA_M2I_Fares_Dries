package org.example.tptodolist.controller;


import org.example.tptodolist.dto.BaseResponseDto;
import org.example.tptodolist.dto.UserLoginDto;
import org.example.tptodolist.entity.User;
import org.example.tptodolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User user) {
        if (userService.createUser(user)) {
            System.out.println(user.toString());
            return new BaseResponseDto("Success");
        } else {
            return new BaseResponseDto("Failed");
        }
    }


    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {

        if (userService.checkUserNameExists(userLoginDto.getEmail())) {

            if (userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword())) {

                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));

                return new BaseResponseDto("Success", data);

            } else {
                return new BaseResponseDto("Wrong password");
            }

        } else {
            return new BaseResponseDto("User Not Exist");
        }


    }



}
