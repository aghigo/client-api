package br.com.uol.mail.api.client.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.ClientDTO;
import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;
import br.com.uol.mail.api.client.domain.dto.WeatherDTO;
import br.com.uol.mail.api.client.entity.Client;
import br.com.uol.mail.api.client.entity.Geolocalization;
import br.com.uol.mail.api.client.entity.Weather;
import br.com.uol.mail.api.client.exceptions.ClientAlreadyExistsException;
import br.com.uol.mail.api.client.exceptions.ClientNotFoundException;
import br.com.uol.mail.api.client.repository.ClientRepository;

/**
 * Service class with implementations of business rules for Client management
 * 
 * @see ClientService
 */
@Service
public class ClientServiceImpl implements ClientService {
	private WeatherService weatherService;
	private GeolocalizationService geolocalizationService;
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(WeatherService weatherService, GeolocalizationService geolocalizationService, ClientRepository clientRepository) {
		this.weatherService = weatherService;
		this.geolocalizationService = geolocalizationService;
		this.clientRepository = clientRepository;
	}
	
	@Override
	public List<ClientDTO> getAllClients() {
		List<Client> clients = this.clientRepository.getAllClients();
		List<ClientDTO> response = new ArrayList<>();
		for(Client client : clients) {
			ClientDTO dto = new ClientDTO(client.getName(), client.getEmail(), client.getAge());
			response.add(dto);
		}
		return Collections.unmodifiableList(response);
	}

	@Override
	public ClientDTO getClientById(Long id) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		return new ClientDTO(client.getName(), client.getEmail(), client.getAge());
	}

	@Override
	public void createClient(ClientDTO request) throws ClientAlreadyExistsException {
		if(this.clientRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new ClientAlreadyExistsException("Client with e-mail address '" + request.getEmail() + "' already exists");
		}
		
		Client client = new Client();
		client.setName(request.getName());
		client.setEmail(request.getEmail());
		client.setAge(request.getAge());
		
		String ipAddress = request.getIpAddress();
		if(ipAddress != null && ipAddress.trim().isEmpty()) {
			GeolocalizationDTO geolocalizationDTO = this.geolocalizationService.getByIpAddress(ipAddress);
			Geolocalization geolocalization = this.geolocalizationService.saveGeolocalization(geolocalizationDTO);
			WeatherDTO weatherDTO = this.weatherService.findByGeolocalization(geolocalizationDTO);
			Weather weather = this.weatherService.saveWeatherByGeolocalization(weatherDTO, geolocalization);
			client.setWeatherWhenCreated(weather);
		}
		
		this.clientRepository.save(client);
	}
	
	@Override
	public void updateClientById(Long id, ClientDTO request) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		client.setName(request.getName());
		client.setEmail(request.getEmail());
		client.setAge(request.getAge());
		this.clientRepository.save(client);
	}

	@Override
	public void deleteClientById(Long id) throws ClientNotFoundException {
		Client client = this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
		this.clientRepository.delete(client);
	}
}
