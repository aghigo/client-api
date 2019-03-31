package br.com.uol.mail.api.client.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.entity.Client;
import br.com.uol.mail.api.client.exceptions.ClientAlreadyExistsException;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;
import br.com.uol.mail.api.client.repository.ClientRepository;

/**
 * Service class with implementations of business rules for Client management
 * 
 * @see ClientService
 */
@Service
public class ClientServiceImpl implements ClientService {
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Override
	public List<ClientDTO> getAllClients() {
		List<Client> clients = this.clientRepository.getAllClients();
		List<ClientDTO> response = new ArrayList<>();
		for(Client client : clients) {
			ClientDTO dto = ClientDTO.builder()
					.name(client.getName())
					.email(client.getEmail())
					.age(client.getAge())
					.build();
			response.add(dto);
		}
		return Collections.unmodifiableList(response);
	}

	@Override
	public ClientDTO getClientById(Long id) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		return ClientDTO.builder().name(client.getName()).email(client.getEmail()).age(client.getAge()).build();
	}

	@Override
	public void createClient(ClientDTO request) throws ClientAlreadyExistsException {
		if(this.clientRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new ClientAlreadyExistsException("Client with e-mail address '" + request.getEmail() + "' already exists");
		}
		Client client = Client.builder().name(request.getName()).email(request.getEmail()).age(request.getAge()).build();
		this.clientRepository.save(client);
	}
	
	@Override
	public void updateClientById(Long id, ClientDTO request) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		client.setName(request.getName());
		client.setEmail(request.getEmail());
		client.setAge(request.getAge());
		this.clientRepository.save(client);
	}

	@Override
	public void deleteClientById(Long id) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		this.clientRepository.delete(client);
	}
}
