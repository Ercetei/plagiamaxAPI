package com.infotel.plagiamax.model;

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

@Entity
@Table(name = "match_vs")
public class Match extends DBItem {

	private String label;
	private Integer status;

	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_MATCH, PlaceContract.ASSOCIATION_PLAYER,
			PlaceContract.ASSOCIATION_TEAM, PlaceContract.ASSOCIATION_COMPETITION })
	private Place place;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchPlayerContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchPlayerContract.ASSOCIATION_MATCH, MatchPlayerContract.ASSOCIATION_PLAYER })
	private List<MatchPlayer> matchplayers;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = EventContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchTeamContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchTeamContract.ASSOCIATION_MATCH })
	private List<MatchTeam> matchteams;

	@ManyToOne
	@JsonIgnoreProperties({ MatchDayContract.ASSOCIATION_MATCH, MatchDayContract.ASSOCIATION_SEASON })
	private MatchDay matchday;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = MatchBetContract.ASSOCIATION_MATCH)
	@JsonIgnoreProperties({ MatchBetContract.ASSOCIATION_MATCH, MatchBetContract.ASSOCIATION_TEAM,
			BetTypeContract.ASSOCIATION_BETLINE })
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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<MatchPlayer> getMatchplayers() {
		return matchplayers;
	}

	public void setMatchplayers(List<MatchPlayer> matchplayers) {
		this.matchplayers = matchplayers;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<MatchTeam> getMatchteams() {
		return matchteams;
	}

	public void setMatchteams(List<MatchTeam> matchteams) {
		this.matchteams = matchteams;
	}

	public MatchDay getMatchday() {
		return matchday;
	}

	public void setMatchday(MatchDay matchday) {
		this.matchday = matchday;
	}

	public List<MatchBet> getMatchbets() {
		return matchbets;
	}

	public void setMatchbets(List<MatchBet> matchbets) {
		this.matchbets = matchbets;
	}

	public Match() {
		super();
	}

}
