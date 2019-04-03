package br.com.uol.mail.api.client.dao;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;

public interface GeolocalizationDAO {
	/**
	 * Finds the Geolocalization data by an given IP Address
	 * 
	 * @see Geolocalization
	 * @see GeolocalizationDTO
	 * 
	 * @param ipAddress the IP Address
	 * 
	 * @return the geolocalization data related to the IP Address
	 */
	GeolocalizationDTO findByIpAddress(String ipAddress);
}
