package com.esprit.badmanager.services;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.esprit.badmanager.entities.Mail;

@Service
public class EmailService {

	public void sendEmailTest() throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		//--
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("hazembenbz@gmail.com",System.getenv("GMAIL_APP_PASS"));
			}
		});
		//--
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("hazembenbz@gmail.com"));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hazembenbz@gmail.com,junkozien@gmail.com"));
		msg.setSubject("Java mail testing");
		msg.setContent("Take this message and leave it as is","text/html");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Technique 2 to send a message","text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
		
		attachPart.attachFile("/home/harozien/Pictures/arch_logo.png");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		
		Transport.send(msg);
		
	}
	
	public void sendEmail(Mail mail) throws AddressException, MessagingException, IOException {
		// parse recipients
		String recipients = String.join(", ", mail.getRecipientsList());
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		//--
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("hazembenbz@gmail.com",System.getenv("GMAIL_APP_PASS"));
			}
		});
		//--
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("hazembenbz@gmail.com"));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
		msg.setSubject(mail.getSubject());
		msg.setContent(mail.getContent(),"text/html");
		msg.setSentDate(new Date());
		
//		MimeBodyPart messageBodyPart = new MimeBodyPart();
//		messageBodyPart.setContent("Technique 2 to send a message","text/html");
//		
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		MimeBodyPart attachPart = new MimeBodyPart();
		
//		attachPart.attachFile("/home/harozien/Pictures/arch_logo.png");
//		multipart.addBodyPart(attachPart);
//		msg.setContent(multipart);
		
		Transport.send(msg);
		
	}
}
