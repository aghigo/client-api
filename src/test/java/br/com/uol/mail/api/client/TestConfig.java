package br.com.uol.mail.api.client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"br.com.uol.mail.api.client", 
		"br.com.uol.mail.api.client.controller.rest",
		"br.com.uol.mail.api.client.dao",
		"br.com.uol.mail.api.client.dao.rest",
		"br.com.uol.mail.api.client.domain.dto",
		"br.com.uol.mail.api.client.entity",
		"br.com.uol.mail.api.client.exceptions",
		"br.com.uol.mail.api.client.repository",
		"br.com.uol.mail.api.client.service"
})
public class TestConfig {}
