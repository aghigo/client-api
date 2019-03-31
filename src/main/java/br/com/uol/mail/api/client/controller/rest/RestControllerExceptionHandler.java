package br.com.uol.mail.api.client.controller.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.gson.JsonObject;

/**
 * Component responsible for handling exceptions thrown by Rest Controllers
 */
@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {	
	@ExceptionHandler(value = { ResponseStatusException.class })
	protected ResponseEntity<Object> handleResponseStatusExceptions(ResponseStatusException ex) {
		logger.error(ex.getMessage(), ex);
		JsonObject responseBody = new JsonObject();
		responseBody.addProperty("error", ex.getStatus().getReasonPhrase());
		responseBody.addProperty("status", ex.getStatus().value());
		responseBody.addProperty("message", ex.getReason());
		responseBody.addProperty("timestamp", new Date().getTime());
		return ResponseEntity.status(ex.getStatus()).contentType(MediaType.APPLICATION_JSON_UTF8).body(responseBody.toString());
	}
	
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleGenericExceptions(Exception ex) {
		logger.error(ex.getMessage(), ex);
		JsonObject responseBody = new JsonObject();
		responseBody.addProperty("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		responseBody.addProperty("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseBody.addProperty("message", ex.getMessage());
		responseBody.addProperty("timestamp", new Date().getTime());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON_UTF8).body(responseBody.toString());
		
	}
}
