package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.BetTypeContract;
import com.infotel.plagiamax.contract.EventContract;
import com.infotel.plagiamax.contract.MatchBetContract;
import com.infotel.plagiamax.contract.MatchDayContract;
import com.infotel.plagiamax.contract.MatchPlayerContract;
import com.infotel.plagiamax.contract.MatchTeamContract;
import com.infotel.plagiamax.contract.PlaceContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Match.
 */
@Entity
@Table(name = "match_vs")
public class Match extends DBItem {

	/** The date. */
	private Date date;
	
	
	/** The status. 
	 * 
	 * 1 : Canceled
	 * 2 : Reported
	 * 3 : To come
	 * 4 : In progress
	 * 5 : Finished 
	 * 
	 */
	private Integer status;

	/** The place. */
	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_MATCH, PlaceContract.ASSOCIATION_PLAYER,
			PlaceContract.ASSOCIATION_TEAM, PlaceContract.ASSOCIATION_COMPETITION })
	private Place place;

	/** The matchplayers. */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchPlayerContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchPlayerContract.ASSOCIATION_MATCH, MatchPlayerContract.ASSOCIATION_PLAYER })
	private List<MatchPlayer> matchplayers;

	/** The events. */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = EventContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	/** The matchteams. */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchTeamContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchTeamContract.ASSOCIATION_MATCH })
	private List<MatchTeam> matchteams;

	/** The matchday. */
	@ManyToOne
	@JsonIgnoreProperties({ MatchDayContract.ASSOCIATION_MATCH })
	private MatchDay matchday;

	/** The matchbets. */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchBetContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchBetContract.ASSOCIATION_MATCH, MatchBetContract.ASSOCIATION_TEAM,
			BetTypeContract.ASSOCIATION_BETLINE })
	private List<MatchBet> matchbets;

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Gets the matchplayers.
	 *
	 * @return the matchplayers
	 */
	public List<MatchPlayer> getMatchplayers() {
		return matchplayers;
	}

	/**
	 * Sets the matchplayers.
	 *
	 * @param matchplayers the new matchplayers
	 */
	public void setMatchplayers(List<MatchPlayer> matchplayers) {
		this.matchplayers = matchplayers;
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
	 * Gets the matchday.
	 *
	 * @return the matchday
	 */
	public MatchDay getMatchday() {
		return matchday;
	}

	/**
	 * Sets the matchday.
	 *
	 * @param matchday the new matchday
	 */
	public void setMatchday(MatchDay matchday) {
		this.matchday = matchday;
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
	 * Instantiates a new match.
	 */
	public Match() {
		super();
	}

}
