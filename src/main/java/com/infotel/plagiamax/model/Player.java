package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.contract.EventContract;
import com.infotel.plagiamax.contract.MatchPlayerContract;
import com.infotel.plagiamax.contract.PeriodContract;
import com.infotel.plagiamax.contract.PlayerBetContract;
import com.infotel.plagiamax.contract.StatContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "player")
public class Player extends DBItem {

	private String firstname;

	@Column(name = "lastname", nullable = false)
	private String lastname;
	private Date birthdate;

	@Column(name = "status", nullable = false)
	private String status;

	@ManyToOne(targetEntity = Place.class)
	@JsonManagedReference
	private Place place;

	@OneToMany(targetEntity = Period.class, mappedBy = PeriodContract.ASSOCIATION_PLAYER)
	@JsonBackReference
	private List<Period> periods;

	@OneToMany(targetEntity = Stat.class, mappedBy = StatContract.ASSOCIATION_PLAYER)
	@JsonBackReference
	private List<Stat> stats;

//Association to MATCHPLAYER
	@OneToMany(targetEntity = MatchPlayer.class, mappedBy = MatchPlayerContract.ASSOCIATION_PLAYER)
	@JsonBackReference
	private List<MatchPlayer> matchplayers;

//Association to EVENT
	@OneToMany(targetEntity = Event.class, mappedBy = EventContract.ASSOCIATION_PLAYER)
	@JsonBackReference
	private List<Event> events;

	@OneToMany(targetEntity = PlayerBet.class, mappedBy = PlayerBetContract.ASSOCIATION_PLAYER)
	@JsonBackReference
	private List<PlayerBet> playersbets;

	public List<PlayerBet> getPlayersbets() {
		return playersbets;
	}

	public void setPlayersbets(List<PlayerBet> playersbets) {
		this.playersbets = playersbets;
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

	public Player(Long id, String firstname, String lastname, Date birthdate, String status, Place place, List<Period> periods,
			List<Stat> stats, List<MatchPlayer> matchplayers, List<Event> events,
			List<PlayerBet> playersbets) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.status = status;
		this.place = place;
		this.periods = periods;
		this.stats = stats;
		this.matchplayers = matchplayers;
		this.events = events;
		this.playersbets = playersbets;
	}
	
	

}
