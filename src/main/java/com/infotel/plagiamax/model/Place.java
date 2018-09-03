package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idplace", unique = true, nullable = false)
	private Long idplace;
	private String country;
	private String city;
	private String stadium;
	
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Place(Long idplace, String country, String city, String stadium) {
		super();
		this.idplace = idplace;
		this.country = country;
		this.city = city;
		this.stadium = stadium;
	}
	
	public Long getIdplace() {
		return idplace;
	}
	public void setIdplace(Long idplace) {
		this.idplace = idplace;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
		
}
