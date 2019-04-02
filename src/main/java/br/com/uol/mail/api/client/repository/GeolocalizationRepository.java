package br.com.uol.mail.api.client.repository;

import java.net.InetAddress;

import org.springframework.stereotype.Repository;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;

/**
 * Repository interface with signature methods to retrieve geolocalization data
 * @see GeolocalizationDTO
 *
 */
@Repository
public interface GeolocalizationRepository {
	/**
	 * Gets the geolocalization data by an IP Address
	 * @see GeolocalizationDTO
	 * 
	 * @param ipAddress
	 * 
	 * @return Geolocalization data
	 */
	GeolocalizationDTO getByIpAddress(InetAddress ipAddress);
}
