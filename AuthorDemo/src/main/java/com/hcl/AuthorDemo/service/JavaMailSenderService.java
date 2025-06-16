package com.hcl.AuthorDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shivasaivardhan1729@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		javaMailSender.send(message);
	}

}
