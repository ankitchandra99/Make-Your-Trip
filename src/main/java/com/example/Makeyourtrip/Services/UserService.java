package com.example.Makeyourtrip.Services;

import com.example.Makeyourtrip.Models.User;
import com.example.Makeyourtrip.Repositories.UserRepository;
import com.example.Makeyourtrip.RequestDto.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public String addUser(AddUserDto addUserDto){

        User user =  User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();

        userRepository.save(user);





        return "User has been saved successfully";

    }

}
