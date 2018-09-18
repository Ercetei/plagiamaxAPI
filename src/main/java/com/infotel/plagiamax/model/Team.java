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
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "team")
public class Team extends DBItem {

	@Column(nullable = false)
	private String label;

	@Column(nullable = false)
	private Integer status;
	private Date creationdate;

	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_COMPETITION, PlaceContract.ASSOCIATION_MATCH,
			PlaceContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private Place place;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = PeriodContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ PeriodContract.ASSOCIATION_PLAYER, PeriodContract.ASSOCIATION_TEAM })
	private List<Period> periods;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = StatContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ StatContract.ASSOCIATION_CHILDREN, StatContract.ASSOCIATION_PARENT,
			StatContract.ASSOCIATION_PLAYER, StatContract.ASSOCIATION_TEAM })
	private List<Stat> stats;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchTeamContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ MatchTeamContract.ASSOCIATION_MATCH, MatchTeamContract.ASSOCIATION_TEAM })
	private List<MatchTeam> matchteams;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = EventContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchBetContract.ASSOCIATION_TEAM)
	@JsonIgnoreProperties({ MatchBetContract.ASSOCIATION_MATCH, MatchBetContract.ASSOCIATION_TEAM })
	private List<MatchBet> matchbets;

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

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public List<MatchTeam> getMatchteams() {
		return matchteams;
	}

	public void setMatchteams(List<MatchTeam> matchteams) {
		this.matchteams = matchteams;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<MatchBet> getMatchbets() {
		return matchbets;
	}

	public void setMatchbets(List<MatchBet> matchbets) {
		this.matchbets = matchbets;
	}

	public Team() {
		super();
	}
}
