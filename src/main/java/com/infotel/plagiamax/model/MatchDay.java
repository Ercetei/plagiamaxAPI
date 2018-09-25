package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.SeasonContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class MatchDay. Corresponds to a "Match Day" in a competition's point of
 * view. Generally represents a week for championships, or a phase for cups.
 */
@Entity
@Table(name = "matchday")
public class MatchDay extends DBItem {

	/** The label. */
	private String label;

	/** The season it takes place in. */
	@ManyToOne
	@JsonIgnoreProperties({ SeasonContract.ASSOCIATION_MATCHDAY })
	private Season season;

	/** The matches. */
	@OneToMany(mappedBy = MatchContract.ASSOCIATION_MATCHDAY, cascade = { CascadeType.REMOVE })
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private List<Match> matchs;

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
	 * Gets the season.
	 *
	 * @return the season
	 */
	public Season getSeason() {
		return season;
	}

	/**
	 * Sets the season.
	 *
	 * @param season the new season
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * Instantiates a new match day.
	 */
	public MatchDay() {
		super();
	}
}
