package br.com.uol.mail.api.client.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Weather implements Serializable {
	private static final long serialVersionUID = -7744982170906714088L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date instant;
	
	@Column
	private Double minimumTemperature;
	
	@Column
	private Double maximumTemperature;
	
	@ManyToOne
	private Geolocalization geolocalization;
	
	public Weather( ) {
		super();
	}
	
	public Weather(Long id, Date instant, Double minimumTemperature, Double maximumTemperature, Geolocalization geolocalization) {
		this.id = id;
		this.instant = instant;
		this.minimumTemperature = minimumTemperature;
		this.maximumTemperature = maximumTemperature;
		this.geolocalization = geolocalization;
	}
}
