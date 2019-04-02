package br.com.uol.mail.api.client.service;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.uol.mail.api.client.domain.dto.GeolocalizationDTO;
import br.com.uol.mail.api.client.repository.GeolocalizationRepository;

@Service
public class GeolocalizationServiceImpl implements GeolocalizationService {
	@Qualifier("IpVigilanteDAO")
	private GeolocalizationRepository geolocalizationRepository;

	@Override
	public GeolocalizationDTO getByIpAddress(InetAddress ipAddress) {
		// TODO Auto-generated method stub
		return null;
	}
}
