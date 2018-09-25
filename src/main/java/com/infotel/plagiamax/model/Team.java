package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.EventContract;
import com.infotel.plagiamax.contract.MatchBetContract;
import com.infotel.plagiamax.contract.MatchTeamContract;
import com.infotel.plagiamax.contract.PeriodContract;
import com.infotel.plagiamax.contract.PlaceContract;
import com.infotel.plagiamax.contract.StatContract;
import com.infotel.plagiamax.contract.TeamBetContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Team. Keeps all the information regarding a team.
 */
@Entity
@Table(name = "team")
public class Team extends DBItem {

	/** The label. */
	@Column(nullable = false)
	private String label;

	/**
	 * The status.
	 * 
	 * 1 : Active 2 : Inactive
	 * 
	 */
	@Column(nullable = false)
	private Integer status;

	/** The creation date. */
	private Date creationdate;

	/** The city / Country / Stadium. */
	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_COMPETITION, PlaceContract.ASSOCIATION_MATCH,
			PlaceContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private Place place;

	/** The periods. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = PeriodContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ PeriodContract.ASSOCIATION_PLAYER, PeriodContract.ASSOCIATION_TEAM })
	private List<Period> periods;

	/** The stats. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = StatContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ StatContract.ASSOCIATION_CHILDREN, StatContract.ASSOCIATION_PARENT,
			StatContract.ASSOCIATION_PLAYER, StatContract.ASSOCIATION_TEAM })
	private List<Stat> stats;

	/** The matchteams. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchTeamContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ MatchTeamContract.ASSOCIATION_MATCH, MatchTeamContract.ASSOCIATION_TEAM })
	private List<MatchTeam> matchteams;

	/** The events. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = EventContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	/** The matchbets. */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchBetContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ MatchBetContract.ASSOCIATION_MATCH, MatchBetContract.ASSOCIATION_TEAM })
	private List<MatchBet> matchbets;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = TeamBetContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ TeamBetContract.ASSOCIATION_TEAM })
	private List<TeamBet> teambets;

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
	 * Gets the creationdate.
	 *
	 * @return the creationdate
	 */
	public Date getCreationdate() {
		return creationdate;
	}

	/**
	 * Sets the creationdate.
	 *
	 * @param creationdate the new creationdate
	 */
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
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
	 * Gets the stats.
	 *
	 * @return the stats
	 */
	public List<Stat> getStats() {
		return stats;
	}

	/**
	 * Sets the stats.
	 *
	 * @param stats the new stats
	 */
	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	/**
	 * Gets the periods.
	 *
	 * @return the periods
	 */
	public List<Period> getPeriods() {
		return periods;
	}

	/**
	 * Sets the periods.
	 *
	 * @param periods the new periods
	 */
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	/**
	 * Gets the matchteams.
	 *
	 * @return the matchteams
	 */
	public List<MatchTeam> getMatchteams() {
		return matchteams;
	}

	/**
	 * Sets the matchteams.
	 *
	 * @param matchteams the new matchteams
	 */
	public void setMatchteams(List<MatchTeam> matchteams) {
		this.matchteams = matchteams;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 *
	 * @param events the new events
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * Gets the matchbets.
	 *
	 * @return the matchbets
	 */
	public List<MatchBet> getMatchbets() {
		return matchbets;
	}

	/**
	 * Sets the matchbets.
	 *
	 * @param matchbets the new matchbets
	 */
	public void setMatchbets(List<MatchBet> matchbets) {
		this.matchbets = matchbets;
	}

	/**
	 * Instantiates a new team.
	 */
	public Team() {
		super();
	}
}
