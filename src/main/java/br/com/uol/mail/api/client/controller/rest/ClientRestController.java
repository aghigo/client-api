package br.com.uol.mail.api.client.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.service.ClientService;

@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(value = "/api/rest/v1/clients")
@RestController
public class ClientRestController {
	@Qualifier("ClientServiceImpl")
	private ClientService service;
	
	@Autowired
	public ClientRestController(ClientService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllClients() {
		List<ClientDTO> clients = this.service.getAllClients();
		return ResponseEntity.ok(clients);
	}
}