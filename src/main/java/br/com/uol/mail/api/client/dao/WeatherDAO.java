package br.com.uol.mail.api.client.dao;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;
import br.com.uol.mail.api.client.domain.dto.WeatherDTO;

public interface WeatherDAO {
	/**
	 * Finds the weather data related to a given geolocalization
	 * 
	 * @see Weather
	 * @see WeatherDTO
	 * @see Geolocalization
	 * @see GeolocalizationDTO
	 * 
	 * @param geolocation the geolocalization data (such as lattitude, longitude, etc).
	 * 
	 * @return the Weather data
	 */
	WeatherDTO getWeatherByGeolocation(GeolocalizationDTO geolocation);
}
