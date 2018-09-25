package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.CompetitionContract;
import com.infotel.plagiamax.contract.MatchDayContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Season. Specifies the beginning / End dates for a specific
 * competition.
 */
@Entity
@Table(name = "season")
public class Season extends DBItem {

	/** The start date. */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;

	/** The end date. */
	@Temporal(TemporalType.DATE)
	private Date endDate;

	/** The status. */
	@Column(nullable = false)
	private Integer status;

	/** The competition. */
	@ManyToOne
	@JsonIgnoreProperties({ CompetitionContract.ASSOCIATION_CATEGORY, CompetitionContract.ASSOCIATION_PLACE,
			CompetitionContract.ASSOCIATION_SEASON })
	private Competition competition;

	/** The matchdays. */
	@OneToMany(mappedBy = MatchDayContract.ASSOCIATION_SEASON, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnoreProperties({ MatchDayContract.ASSOCIATION_MATCH, MatchDayContract.ASSOCIATION_SEASON })
	private List<MatchDay> matchdays;

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * Gets the competition.
	 *
	 * @return the competition
	 */
	public Competition getCompetition() {
		return competition;
	}

	/**
	 * Sets the competition.
	 *
	 * @param competition the new competition
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * Gets the matchdays.
	 *
	 * @return the matchdays
	 */
	public List<MatchDay> getMatchdays() {
		return matchdays;
	}

	/**
	 * Sets the matchdays.
	 *
	 * @param matchdays the new matchdays
	 */
	public void setMatchdays(List<MatchDay> matchdays) {
		this.matchdays = matchdays;
	}

	/**
	 * Instantiates a new season.
	 */
	public Season() {
		super();
	}
}
