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
import com.infotel.plagiamax.contract.PlaceContract;
import com.infotel.plagiamax.contract.SeasonContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Competition.
 */
@Entity
@Table(name = "competition")
public class Competition extends DBItem {

	/** The name of the competition. */
	private String label;

	/**
	 * The status.
	 * 
	 * 1 : Active 
	 * 2 : Deprecated
	 * 
	 */
	private Integer status;

	/**
	 * The type of competition.
	 * 
	 * 1 : Cup 
	 * 2 : Championship
	 * 
	 */
	private Integer type;

	/** The categories. */
	@ManyToMany(mappedBy = CategoryContract.ASSOCIATION_COMPETITION)
	@JsonIgnoreProperties({ CategoryContract.ASSOCIATION_COMPETITION })
	private List<Category> categories;

	/** The place. */
	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_COMPETITION, PlaceContract.ASSOCIATION_MATCH,
			PlaceContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private Place place;

	/** The seasons. */
	@OneToMany(mappedBy = SeasonContract.ASSOCIATION_COMPETITION, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnoreProperties({ SeasonContract.ASSOCIATION_COMPETITION, SeasonContract.ASSOCIATION_MATCHDAY })
	private List<Season> seasons;

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * Sets the categories.
	 *
	 * @param categories the new categories
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * Gets the seasons.
	 *
	 * @return the seasons
	 */
	public List<Season> getSeasons() {
		return seasons;
	}

	/**
	 * Sets the seasons.
	 *
	 * @param seasons the new seasons
	 */
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	/**
	 * Instantiates a new competition.
	 */
	public Competition() {
		super();
	}

	/**
	 * Instantiates a new competition.
	 *
	 * @param id the id
	 */
	public Competition(Integer id) {
		this.id = id.longValue();
	}
}
