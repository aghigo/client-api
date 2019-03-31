package br.com.uol.mail.api.client.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.uol.mail.api.client.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestConfig.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientRestControllerIntegrationTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private ClientRestController controller;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String getBaseUrl() {
		return "http://localhost:" + this.port + "/api/rest/v1/clients";
	}
	
	private void setTestRestTemplateContentType(String type) {
		restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
			request.getHeaders().remove(HttpHeaders.CONTENT_TYPE);
			request.getHeaders().add(HttpHeaders.CONTENT_TYPE, type);
			return execution.execute(request, body);
		}));
	}
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(restTemplate).isNotNull();
		assertThat(port).isGreaterThan(0);
	}
	
	@Test
	public void createClient_WithInvalidName_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void createClient_WithInvalidEmail_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void createClient_WithInvalidAge_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void createClient_withExistingEmail_shouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void createClient_WithValidRequestBody_ShouldReturnStatusCreated() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_WithInvalidId_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_WithInvalidButNonExistingId_ShouldReturnStatusErrorNotFound() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_WithInvalidName_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_WithInvalidEmail_ShouldReturnErrorBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_WithInvalidAge_ShouldReturnErrorBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void updateClientById_withValidIdAndRequestBody_ShouldReturnStatusOk() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void getAllClients_ShouldReturnClientList() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void getClientById_WithEmptyId_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void getClientById_WithInvalidId_ShouldReturnErrorStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void getClientById_WithValidButNonExistingId_ShouldReturnErrorStatusNotFound() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void getClientById_WithValidIdAndExistingId_ShouldReturnOKWithClientInResponseBody() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void deleteClientById_withInvalidId_shouldReturnStatusBadRequest() {
		Assert.fail("TODO - Test not implemented");
	}
	
	@Test
	public void deleteClientById_withValidId_shouldReturnStatusOk() {
		Assert.fail("TODO - Test not implemented");
	}
}
