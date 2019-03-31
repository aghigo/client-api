package br.com.uol.mail.api.client.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

	@Override
	public List<ClientDTO> getAllClients() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	public ClientDTO getClientById() throws ClientNotFoundException {
		// TODO Auto-generated method stub
		return ClientDTO.builder().build();
	}

	@Override
	public void updateClientById(Long id, ClientDTO client) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClientById(Long id) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
