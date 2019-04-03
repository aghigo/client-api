package br.com.uol.mail.api.client.domain.dto;

public class WeatherDTO {
	private final Long instant;
	private final Double maximumTemperature;
	private final Double minimumTemperature;
	
	public WeatherDTO(Double maximumTemperature, Double minimumTemperature, Long instant) {
		this.maximumTemperature = maximumTemperature;
		this.minimumTemperature = minimumTemperature;
		this.instant = instant;
	}

	public Double getMaximumTemperature() {
		return maximumTemperature;
	}

	public Double getMinimumTemperature() {
		return minimumTemperature;
	}
	
	public Long getInstant() {
		return this.instant;
	}
}
