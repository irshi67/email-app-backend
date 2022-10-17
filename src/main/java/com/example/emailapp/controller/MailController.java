package com.example.emailapp.controller;

import com.example.emailapp.model.Mail;
import com.example.emailapp.model.MailStatus;
import com.example.emailapp.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/sent")
    public void sendMail(@RequestBody Mail mail) {
        mailService.sendMail(mail);
    }

    @GetMapping("{id}/update")
    public void updateMail(@PathVariable("id") String id){
        mailService.updateMail(id);
    }

    @GetMapping("/{id}/update/{status}")
    public void updateMailStatus(@PathVariable("id") String id, @PathVariable("status") MailStatus status){
        mailService.updateMailStatus(id, status);
    }

    @GetMapping("/{id}")
    public Mail getMail(@PathVariable String id){
       return mailService.getMail(id);
    }

}