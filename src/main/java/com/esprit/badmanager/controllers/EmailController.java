package com.esprit.badmanager.controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.badmanager.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send")
	public String sendEmail() throws AddressException, MessagingException, IOException{	
		System.out.println("EMAIL PATH HIT");
		emailService.sendEmail();
		return "Email sent";
	}
}
