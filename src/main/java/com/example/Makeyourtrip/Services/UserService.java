package com.example.Makeyourtrip.Services;

import com.example.Makeyourtrip.Models.User;
import com.example.Makeyourtrip.Repositories.UserRepository;
import com.example.Makeyourtrip.RequestDto.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;

    public String addUser(AddUserDto addUserDto){

        User user =  User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();

        userRepository.save(user);


        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hi! "+user.getName()+"\n" +
                "Welcome to Make your Trip Website. Book your flights, buses and trains conviniently here";

        mailMessage.setSubject("Welcome to Make your Trip");
        mailMessage.setFrom("springacciojob@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setText(body);

        emailSender.send(mailMessage);


        return "User has been saved successfully";

    }

}
