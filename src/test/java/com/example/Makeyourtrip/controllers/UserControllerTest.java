package com.example.Makeyourtrip.controllers;


import com.example.Makeyourtrip.Controllers.UserController;
import com.example.Makeyourtrip.Models.User;
import com.example.Makeyourtrip.Repositories.UserRepository;
import com.example.Makeyourtrip.RequestDto.AddUserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.yaml.snakeyaml.emitter.Emitter;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;


    @Test
    public void testUser(){
        AddUserDto addUserDto = new AddUserDto();

        // Act
        Assertions.assertThrows(NullPointerException.class, () -> {
            userController.addUser(addUserDto);
        });

        // Assert

    }

}
