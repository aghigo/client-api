package br.com.uol.mail.api.client.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.uol.mail.api.client.repository.WeatherRepository;

/**
 * DAO class to retrieve Weather data from the Meta Weather API
 * {@link https://metaweather.com/api/}
 *
 */
@Component
public class MetaWeatherDAO implements WeatherRepository {
	@Value("${weather.api.url}")
	private String baseUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public MetaWeatherDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	private String getLocationUrl(Double lattitude, Double longitude) {
		String templateUrl = this.baseUrl + "/api/location/?lattlong=%.2f,%.2f";
		return String.format(templateUrl, lattitude, longitude);
	}
}
