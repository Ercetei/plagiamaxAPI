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
import com.infotel.plagiamax.contract.MatchPlayerContract;
import com.infotel.plagiamax.contract.PeriodContract;
import com.infotel.plagiamax.contract.PlaceContract;
import com.infotel.plagiamax.contract.PlayerBetContract;
import com.infotel.plagiamax.contract.StatContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "player")
public class Player extends DBItem {

	private String firstname;

	@Column(nullable = false)
	private String lastname;
	private Date birthdate;

	@Column(nullable = false)
	private String status;

	@ManyToOne
	@JsonIgnoreProperties({ PlaceContract.ASSOCIATION_COMPETITION, PlaceContract.ASSOCIATION_MATCH,
			PlaceContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private Place place;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = PeriodContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ PeriodContract.ASSOCIATION_PLAYER, PeriodContract.ASSOCIATION_TEAM })
	private List<Period> periods;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = StatContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ StatContract.ASSOCIATION_CHILDREN, StatContract.ASSOCIATION_PARENT,
			StatContract.ASSOCIATION_PLAYER, PlaceContract.ASSOCIATION_TEAM })
	private List<Stat> stats;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = MatchPlayerContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ MatchPlayerContract.ASSOCIATION_MATCH, MatchPlayerContract.ASSOCIATION_PLAYER })
	private List<MatchPlayer> matchplayers;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = EventContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ EventContract.ASSOCIATION_MATCH, EventContract.ASSOCIATION_PLAYER,
			EventContract.ASSOCIATION_TEAM })
	private List<Event> events;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = PlayerBetContract.ASSOCIATION_PLAYER)
	@JsonIgnoreProperties({ PlayerBetContract.ASSOCIATION_PLAYER })
	private List<PlayerBet> playerbets;

	public List<PlayerBet> getPlayerbets() {
		return playerbets;
	}

	public void setPlayerbets(List<PlayerBet> playerbets) {
		this.playerbets = playerbets;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Player() {
		super();
	}
}
