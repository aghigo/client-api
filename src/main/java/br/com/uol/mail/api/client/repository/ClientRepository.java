package br.com.uol.mail.api.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.uol.mail.api.client.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {}
