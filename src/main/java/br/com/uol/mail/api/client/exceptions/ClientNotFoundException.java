package br.com.uol.mail.api.client.exceptions;

public class ClientNotFoundException extends Exception {
	private static final long serialVersionUID = -1362146675239403208L;

	public ClientNotFoundException() {
		super();
	}
	
	public ClientNotFoundException(String message) {
		super(message);
	}
}
