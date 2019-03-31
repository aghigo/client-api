package br.com.uol.mail.api.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;

/**
 * Defines business rules for clients
 */
@Service
public interface ClientService {
	/**
	 * Get a list with all clients available
	 * @return List with all clients available. Empty list, if none.
	 */
	List<ClientDTO> getAllClients();
	
	/**
	 * Get a specific Client based on its unique Id
	 * @return Client instance with the provided Id
	 * @throws ClientNotFoundException if the client was not found
	 */
	ClientDTO getClientById() throws ClientNotFoundException;
	
	/**
	 * Updates a client with a specific id
	 * 
	 * @param id the id of the client to update 
	 * @param client client data to update
	 * 
	 * @throws ClientNotFoundException if the client was not found
	 */
	void updateClientById(Long id, ClientDTO client) throws ClientNotFoundException;
	
	/**
	 * Deletes a client with a specific id
	 * @param id the id of the client to be removed
	 * @throws ClientNotFoundException if the client was not found
	 */
	void deleteClientById(Long id) throws ClientNotFoundException;
}
