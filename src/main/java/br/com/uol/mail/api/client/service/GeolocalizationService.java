package br.com.uol.mail.api.client.service;

import java.net.InetAddress;

import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;

/**
 * Service interface with definition of Geolocalization business rules
 * @author helpdesk
 *
 */
@Service
public interface GeolocalizationService {
	/**
	 * Gets geolocalization data by a given IP Address
	 * @see GeolocalizationDTO
	 * 
	 * @param ipAddress the IP Address
	 * 
	 * @return Geolocalization data such as lattitude and longitude
	 */
	GeolocalizationDTO getByIpAddress(InetAddress ipAddress);
}
