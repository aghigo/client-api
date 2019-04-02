package br.com.uol.mail.api.client.domain.dto;

public class WeatherDTO {
	private final Double maximumTemperature;
	private final Double minimumTemperature;
	
	public WeatherDTO(Double maximumTemperature, Double minimumTemperature) {
		this.maximumTemperature = maximumTemperature;
		this.minimumTemperature = minimumTemperature;
	}

	public Double getMaximumTemperature() {
		return maximumTemperature;
	}

	public Double getMinimumTemperature() {
		return minimumTemperature;
	}
}
