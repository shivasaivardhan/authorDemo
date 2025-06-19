package com.hcl.AuthorDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class JavaMailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shivasaivardhan1729@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		javaMailSender.send(message);
	}
	
	public void sendEmailHtml(String toEmail, String subject) throws MessagingException {
		Context context = new Context();
		context.setVariable("userName", "shiva1729");
		context.setVariable("orderId", "B98H48IC2G8&BD");
		String htmlContent = springTemplateEngine.process("email_temp", context);// preparing the HTML content with dynamic data

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom("shivasaivardhan1729@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(htmlContent);
		javaMailSender.send(message);
	}
	
//	Prepare Dynamic Data: Gather all the variables you want to insert into your email template into a Context object.
//	Locate and Process Template: Tell the SpringTemplateEngine the name of your HTML template file (e.g., email_template) which should reside in src/main/resources/templates/. The engine then combines the template with your dynamic data to produce a complete HTML string.
//	Construct Email: Use JavaMailSender to create a MimeMessage and MimeMessageHelper to easily set the sender, recipient, subject, and the generated HTML content.
//	Send Email: Use javaMailSender.send() to dispatch the email.
	
}
