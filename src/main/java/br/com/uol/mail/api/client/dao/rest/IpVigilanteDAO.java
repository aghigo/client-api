package br.com.uol.mail.api.client.dao.rest;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;
import br.com.uol.mail.api.client.repository.GeolocalizationRepository;

/**
 * DAO class to retrieve geolocalization data from the 'ipvigilante' API
 * {@link https://www.ipvigilante.com}
 * 
 * @see GeolocalizationDTO
 * @see GeolocalizationRepository
 */
@Component
public class IpVigilanteDAO {
	private static final Logger logger = LoggerFactory.getLogger(IpVigilanteDAO.class);
	
	@Value("${geolocalization.api.url}")
	private String baseUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public IpVigilanteDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private String getUrl(String ip) {
		return this.baseUrl + "/json/" + ip;
	}
	
	public GeolocalizationDTO getByIpAddress(InetAddress ipAddress) {
		String ip = ipAddress.getHostAddress();
		String url = this.getUrl(ip);
		ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
		if(!response.getStatusCode().is2xxSuccessful()) {
			logger.error(response.getBody());
			throw new IllegalStateException("Failed to load geolocalization data");
		}
		String body = response.getBody();
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(body).getAsJsonObject();
		if(!json.has("data")) {
			logger.error(response.getBody());
			throw new IllegalStateException("Failed to load gelocalization data");
		}
		JsonObject data = json.get("data").getAsJsonObject();
		Double lattitude = data.get("lattitude").getAsDouble();
		Double longitude = data.get("longitude").getAsDouble();
		return new GeolocalizationDTO(ipAddress, lattitude, longitude);
	}
}
