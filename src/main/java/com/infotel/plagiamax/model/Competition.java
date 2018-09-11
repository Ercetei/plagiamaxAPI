package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.CategoryContract;
import com.infotel.plagiamax.contract.SeasonContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "competition")
public class Competition extends DBItem {

	private String label;

	private Integer status;

	private Integer type;

	@ManyToMany(mappedBy = CategoryContract.ASSOCIATION_COMPETITION)
	@JsonIgnoreProperties({"competitions"})
	private List<Category> categories;

	@ManyToOne
	@JsonIgnoreProperties({ "matchs", "players", "teams", "competitions"})
	private Place place;

	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy = SeasonContract.ASSOCIATION_COMPETITION)
	@JsonIgnoreProperties({ "matchdays", "competition" })
	private List<Season> seasons;

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

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	public Competition() {
		super();
	}
}
