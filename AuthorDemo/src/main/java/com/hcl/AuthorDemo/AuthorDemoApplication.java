package com.hcl.AuthorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1); // Lower order = higher priority
		return resolver;
	}

	//Instead of in-line messages we can externalize all our validation messages into a file like errors.properties
	//(or any name you prefer), and then configure a MessageSource bean in our Spring Boot application
	//to load messages from that file.
	
	//==> This approach give us clean code with internalization and centralization support
}
