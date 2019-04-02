package br.com.uol.mail.api.client.domain.dto;

import java.net.InetAddress;

public class GeolocalizationDTO {
	private final InetAddress ipAddress;
	private final Double lattitude;
	private final Double longitude;
	
	public GeolocalizationDTO(InetAddress ipAddress, Double lattitude, Double longitude) {
		this.ipAddress = ipAddress;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public InetAddress getIpAddress() {
		return ipAddress;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}
}
