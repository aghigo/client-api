package br.com.uol.mail.api.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.entity.Client;
import br.com.uol.mail.api.client.exceptions.ClientAlreadyExistsException;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;

/**
 * Defines business rules for clients
 * 
 * @see ClientDTO
 * @see Client
 */
@Service
public interface ClientService {
	/**
	 * Get a list with all clients available
	 * @see ClientDTO
	 * @see Client
	 * 
	 * @return List with all clients available. An empty list, none.
	 */
	List<ClientDTO> getAllClients();
	
	/**
	 * Get a specific Client based on its unique Id
	 * @see ClientDTO
	 * @see Client
	 * 
	 * @return Client instance with the provided Id
	 * 
	 * @throws ClientNotFoundException if the client was not found
	 */
	ClientDTO getClientById(Long id) throws ClientNotFoundException;
	
	/**
	 * Creates a new client
	 * 
	 * @param client data of the client to create
	 * 
	 * @throws ClientAlreadyExistsException if the client to be created already exists
	 */
	void createClient(ClientDTO request) throws ClientAlreadyExistsException;
	
	/**
	 * Updates a client with a specific id
	 * 
	 * @param id the id of the client to update 
	 * @param request client data to update
	 * 
	 * @throws ClientNotFoundException if the client was not found
	 */
	void updateClientById(Long id, ClientDTO request) throws ClientNotFoundException;
	
	/**
	 * Deletes a client with a specific id
	 * 
	 * @param id the id of the client to be removed
	 * 
	 * @throws ClientNotFoundException if the client was not found
	 */
	void deleteClientById(Long id) throws ClientNotFoundException;
}
