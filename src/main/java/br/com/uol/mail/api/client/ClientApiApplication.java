package br.com.uol.mail.api.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages= { 
		"br.com.uol.mail.api.client", 
		"br.com.uol.mail.api.client.controller.rest",
		"br.com.uol.mail.api.client.service",
		"br.com.uol.mail.api.client.repository",
		"br.com.uol.mail.api.client.domain.dto",
		"br.com.uol.mail.api.client.entity",
		"br.com.uol.mail.api.client.exceptions"
})
@EntityScan(basePackages = "br.com.uol.mail.api.client.entity")
@EnableJpaRepositories(basePackages = "br.com.uol.mail.api.client.repository")
@SpringBootApplication
public class ClientApiApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClientApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}
}
