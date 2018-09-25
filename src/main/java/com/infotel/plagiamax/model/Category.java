package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.CompetitionContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Category.
 * Corresponds to a sport or an activity people can bet on.
 */
@Entity
@Table(name = "category")
public class Category extends DBItem {

	/** The name of the activity. */
	@Column(nullable = false)
	private String label;

	/** The status.
	 * 
	 * 1 : Active
	 * 2 : Deprecated
	 * 
	 */
	@Column(nullable = false)
	private Integer status;

	/** The corresponding competitions. */
	@ManyToMany(cascade = CascadeType.DETACH)
	@JsonIgnoreProperties({ CompetitionContract.ASSOCIATION_CATEGORY, CompetitionContract.ASSOCIATION_PLACE,
			CompetitionContract.ASSOCIATION_SEASON })
	private List<Competition> competitions;

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
	 * Gets the competitions.
	 *
	 * @return the competitions
	 */
	public List<Competition> getCompetitions() {
		return competitions;
	}

	/**
	 * Sets the competitions.
	 *
	 * @param competitions the new competitions
	 */
	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	/**
	 * Instantiates a new category.
	 */
	public Category() {
		super();
	}
}
