package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send/{id}/{email}")
    public String sendEmail(@PathVariable("id") Long id, @PathVariable("email") String to){
        return emailService.sendEmail(to,id);
    }
}
