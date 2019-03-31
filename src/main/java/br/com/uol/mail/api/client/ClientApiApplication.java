package br.com.uol.mail.api.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= { "br.com.uol.mail.api.client", "br.com.uol.mail.api.client.controller.rest" })
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
