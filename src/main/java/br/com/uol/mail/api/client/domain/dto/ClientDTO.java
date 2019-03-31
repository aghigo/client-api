package br.com.uol.mail.api.client.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Immutable DTO object representation of the Client entity
 * @see Client
 */
@Getter
@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
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
}
