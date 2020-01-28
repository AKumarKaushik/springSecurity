package com.reap.project.reap.service;


import com.reap.project.reap.dto.AdminDTO;
import com.reap.project.reap.model.User;
import com.reap.project.reap.model.UserBadges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    UserService userService;


    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(User user) throws MailException {
        System.out.println("#### "+user.getEmail());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("realHelpLine@tothenew.com");
        simpleMailMessage.setSubject("Your Password");
        User userdata = userService.findUserByEmail(user.getEmail());
        simpleMailMessage.setText("This is your Password : "+userdata.getPassword());
        javaMailSender.send(simpleMailMessage);
    }
}
