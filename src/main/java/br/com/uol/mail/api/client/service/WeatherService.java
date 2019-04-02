package br.com.uol.mail.api.client.service;

import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.WeatherDTO;

/**
 * Service interface with signature methods for Weather data business rules
 */
@Service
public interface WeatherService {
	WeatherDTO findByLattitudeAndLongitude(Double lattitude, Double longitude);
}
