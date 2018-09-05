package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "match_vs")
public class Match extends DBItem {

	private String label;
	private Integer status;

//Association to PLACE
	@ManyToOne(targetEntity = Place.class)
	@JsonManagedReference
	private Place place;

//Association to MATCHPLAYER
	@OneToMany(targetEntity = MatchPlayer.class, mappedBy = "match")
	@JsonBackReference
	private List<MatchPlayer> matchplayers;

//Association to PLAYERSTATUS
	@OneToMany(targetEntity = Event.class, mappedBy = "match")
	@JsonBackReference	
	private List<Event> events;

//Association to MATCHTEAM
	@OneToMany(targetEntity = MatchTeam.class, mappedBy = "match")
	@JsonBackReference
	private List<MatchTeam> matchteams;

//Association to SEASON
	@ManyToOne(targetEntity = Season.class)
	@JsonManagedReference
	private Season season;

	@OneToMany(targetEntity = MatchBet.class, mappedBy = "match")
	@JsonBackReference
	private List<MatchBet> matchbets;

//Constructor
	public Match() {
		super();
	}

	public Match(String label, Integer status, Place place, List<MatchPlayer> matchplayers,
			List<Event> events, List<MatchTeam> matchteams, Season season, List<MatchBet> matchbets) {
		super();
		this.label = label;
		this.status = status;
		this.place = place;
		this.matchplayers = matchplayers;
		this.events = events;
		this.matchteams = matchteams;
		this.season = season;
		this.matchbets = matchbets;
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

	public List<Event> getEvent() {
		return events;
	}

	public void setEvent(List<Event> events) {
		this.events = events;
	}

	public List<MatchTeam> getMatchteams() {
		return matchteams;
	}

	public void setMatchteams(List<MatchTeam> matchteams) {
		this.matchteams = matchteams;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public List<MatchBet> getMatchbets() {
		return matchbets;
	}

	public void setMatchbets(List<MatchBet> matchbets) {
		this.matchbets = matchbets;
	}

}
