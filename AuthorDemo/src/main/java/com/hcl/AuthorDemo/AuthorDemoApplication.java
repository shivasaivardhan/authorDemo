package com.hcl.AuthorDemo;

import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class AuthorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorDemoApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("errors");
		return bundleMessageSource;
	}
	//Instead of in-line messages we can externalize all our validation messages into a file like errors.properties
	//(or any name you prefer), and then configure a MessageSource bean in our Spring Boot application
	//to load messages from that file.
	
	//==> This approach give us clean code with internalization and centralization support
}
