package br.com.uol.mail.api.client.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ClientDTO {
	private final String name;
	private final String email;
	private final int age;
}
