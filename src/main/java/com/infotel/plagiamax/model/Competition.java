package com.infotel.plagiamax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@ManyToOne(targetEntity = Category.class)
	private Category category;

	@OneToOne(targetEntity = Place.class)
	private Place place;

	public Competition() {
	}

	public Competition(Long id, String label, Integer status, Integer type, Category category, Place place) {
		super();
		this.setId(id);
		this.label = label;
		this.status = status;
		this.type = type;
		this.category = category;
		this.place = place;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	
}
