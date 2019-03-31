package br.com.uol.mail.api.client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.uol.mail.api.client", "br.com.uol.mail.api.client.controller.rest"})
public class TestConfig {}
