package br.com.uol.mail.api.client.domain.dto;

public class WeatherLocationDTO {
	private final String title;
	private final String locationType;
	private final Long woeid;
	private final Double lattitude;
	private final Double longitude;
	
	public WeatherLocationDTO(String title, String locationType, Long woeid, Double lattitude, Double longitude) {
		super();
		this.title = title;
		this.locationType = locationType;
		this.woeid = woeid;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public String getTitle() {
		return title;
	}

	public String getLocationType() {
		return locationType;
	}

	public Long getWoeid() {
		return woeid;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}
}
