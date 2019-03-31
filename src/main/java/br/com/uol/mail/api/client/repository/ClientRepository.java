package br.com.uol.mail.api.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.uol.mail.api.client.entity.Client;

/**
 * Repository class responsible for the persistance of the Client entities
 * @see Client
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query(value = "SELECT c FROM Client c")
	List<Client> getAllClients();
}
