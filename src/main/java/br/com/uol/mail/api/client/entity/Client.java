package br.com.uol.mail.api.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Client domain entity
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private int age;
}