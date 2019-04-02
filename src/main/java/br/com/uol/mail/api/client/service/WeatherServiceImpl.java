package br.com.uol.mail.api.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.repository.WeatherRepository;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Qualifier("MetaWeatherDAO")
	private WeatherRepository weatherRepository;
	
	@Autowired
	public WeatherServiceImpl(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}
}
