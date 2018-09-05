package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "competition")
public class Competition extends DBItem {

	@Column(nullable = false)
	private String label;

	@Column(nullable = false)
	private Integer status;

	@Column(nullable = false)
	private Integer type;

	@ManyToMany(targetEntity = Category.class)
	@JsonManagedReference
	private List<Category> categories;

	@ManyToOne(targetEntity = Place.class)
	@JsonManagedReference
	private Place place;
	
	@OneToMany(targetEntity = Season.class, mappedBy="competition")
	@JsonBackReference
	private List<Season> season;

	public Competition() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Season> getSeason() {
		return season;
	}

	public void setSeason(List<Season> season) {
		this.season = season;
	}

	public Competition(Long id, String label, Integer status, Integer type, List<Category> categories, Place place,
			List<Season> season) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.type = type;
		this.categories = categories;
		this.place = place;
		this.season = season;
	}

	

}
