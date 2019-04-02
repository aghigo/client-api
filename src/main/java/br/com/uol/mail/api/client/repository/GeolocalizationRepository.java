package br.com.uol.mail.api.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.uol.mail.api.client.entity.Geolocalization;

@Repository
public interface GeolocalizationRepository extends CrudRepository<Geolocalization, Long> {}
