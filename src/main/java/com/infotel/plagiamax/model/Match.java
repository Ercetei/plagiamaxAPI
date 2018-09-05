package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "match")
public class Match extends DBItem {

	private String label;
	private Integer status;

//Association to PLACE
	@ManyToOne(targetEntity = Place.class)
	private Place place;

//Association to MATCHPLAYER
	@OneToOne(targetEntity = MatchPlayer.class)
	private MatchPlayer matchplayer;

//Association to PLAYERSTATUS
	@OneToOne(targetEntity = PlayerStatus.class)
	private PlayerStatus playerstatus;

//Association to MATCHTEAM
	@OneToOne(targetEntity = MatchTeam.class)
	private MatchTeam matchteam;

//Association to SEASON
	@ManyToOne(targetEntity = Season.class)
	private Season season;

	@OneToMany(targetEntity = MatchBet.class, mappedBy="match")
	private List<MatchBet> matchbets;

//Constructor
	public Match() {
		super();
	}

	public Match(String label, Integer status, Place place, MatchPlayer matchplayer, PlayerStatus playerstatus,
			MatchTeam matchteam, Season season, List<MatchBet> matchbets) {
		super();
		this.label = label;
		this.status = status;
		this.place = place;
		this.matchplayer = matchplayer;
		this.playerstatus = playerstatus;
		this.matchteam = matchteam;
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

	public MatchTeam getMatchteam() {
		return matchteam;
	}

	public void setMatchteam(MatchTeam matchteam) {
		this.matchteam = matchteam;
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
