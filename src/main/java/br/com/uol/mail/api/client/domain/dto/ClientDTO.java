package br.com.uol.mail.api.client.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.uol.mail.api.client.entity.Client;

/**
 * Immutable DTO object representation of the Client entity
 * @see Client
 */
public class ClientDTO {
	@NotEmpty(message = "Name must not be empty")
	@NotNull(message = "Name must not be null")
	private final String name;
	
	@NotEmpty(message = "E-mail must not be empty")
	@NotNull(message = "E-mail must not be null")
	@Email(message = "Invalid e-mail address")
	private final String email;
	
	@Positive(message = "Age should be greater than zero")
	private final Integer age;
	
	public ClientDTO(String name, String email, Integer age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Integer getAge() {
		return age;
	}	
}
