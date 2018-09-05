package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Place place;

	@OneToOne(targetEntity = Period.class)
	private Period period;

	@OneToMany(targetEntity = Stat.class, mappedBy = "player")
	private List<Stat> stats;

//Association to MATCHPLAYER
	@OneToOne(targetEntity = MatchPlayer.class)
	private MatchPlayer matchplayer;

//Association to PLAYERSTATUS
	@OneToOne(targetEntity = PlayerStatus.class)
	private PlayerStatus playerstatus;

	@OneToMany(targetEntity = PlayerBet.class)
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

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public MatchPlayer getMatchplayer() {
		return matchplayer;
	}

	public void setMatchplayer(MatchPlayer matchplayer) {
		this.matchplayer = matchplayer;
	}

	public PlayerStatus getPlayerstatus() {
		return playerstatus;
	}

	public void setPlayerstatus(PlayerStatus playerstatus) {
		this.playerstatus = playerstatus;
	}

	public Player(Long id, String firstname, String lastname, Date birthdate, String status, Place place, Period period,
			List<Stat> stats, MatchPlayer matchplayer, PlayerStatus playerstatus, List<PlayerBet> playersbets) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.status = status;
		this.place = place;
		this.period = period;
		this.stats = stats;
		this.matchplayer = matchplayer;
		this.playerstatus = playerstatus;
		this.playersbets = playersbets;
	}

	public Player() {
		super();
	}

}
