package br.com.uol.mail.api.client.service;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.uol.mail.api.client.TestConfig;
import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.entity.Client;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;
import br.com.uol.mail.api.client.repository.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestConfig.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientServiceImplTest {
	@Mock
	private ClientRepository repository;
	
	private ClientServiceImpl service;
	
	private List<Client> mockedClients;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		this.service = new ClientServiceImpl(this.repository);
	}
	
	@Test
	public void getAllClients_shouldReturnListOfClients() {
		Client johnDoe = Client.builder().id(1L).name("john doe").email("john.doe@gmail.com").age(20).build();
		Client client1 = Client.builder().id(2L).name("test").email("test@gmail.com").age(32).build();
		this.mockedClients = new ArrayList<>();
		this.mockedClients.add(johnDoe);
		this.mockedClients.add(client1);
		Mockito.doReturn(this.mockedClients).when(this.repository).getAllClients();
		
		List<ClientDTO> clients = this.service.getAllClients();
		
		Mockito.verify(this.repository, times(1)).getAllClients();
		Assert.assertNotNull(clients);
		Assert.assertEquals(2, clients.size());
		
		ClientDTO client = clients.get(0);
		Assert.assertNotNull(client);
		Assert.assertEquals("john doe", client.getName());
		Assert.assertEquals("john.doe@gmail.com", client.getEmail());
		Assert.assertEquals(Integer.valueOf(20), client.getAge());
		
		client = clients.get(1);
		Assert.assertNotNull(client);
		Assert.assertEquals("test", client.getName());
		Assert.assertEquals("test@gmail.com", client.getEmail());
		Assert.assertEquals(Integer.valueOf(32), client.getAge());
	}
	
	@Test(expected = ClientNotFoundException.class)
	public void getClientById_whenNoClientFound_ShouldThrowException() throws ClientNotFoundException {
		try {
			Mockito.doReturn(Optional.empty()).when(this.repository).findById(Mockito.anyLong());
			this.service.getClientById(1L);
		} catch (ClientNotFoundException e) {
			Mockito.verify(this.repository, times(1)).findById(Mockito.anyLong());
			throw e;
		}
	}
	
	@Test
	public void getClientById_withClientFound_shouldReturnClient() throws ClientNotFoundException {
		Client johnDoe = Client.builder().id(1L).name("john doe").email("john.doe@gmail.com").age(20).build();
		Mockito.doReturn(Optional.of(johnDoe)).when(this.repository).findById(Mockito.anyLong());
		ClientDTO client = this.service.getClientById(1L);
		Assert.assertNotNull(client);
		Assert.assertEquals("john doe", client.getName());
		Assert.assertEquals("john.doe@gmail.com", client.getEmail());
		Assert.assertEquals(Integer.valueOf(20), client.getAge());
	}
}
