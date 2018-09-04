package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "match")
public class Match extends DBItem {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private String label;
	private Integer status;

	
//Association to PLACE
	@OneToMany(targetEntity=Place.class)
	private Place place;

//Association to MATCHPLAYER
	@OneToOne(targetEntity=MatchPlayer.class)
	private MatchPlayer matchplayer;
	
//Association to PLAYERSTATUS
	@OneToOne(targetEntity=PlayerStatus.class)
	private PlayerStatus playerstatus;
	
//Association to MATCHTEAM
	@OneToOne(targetEntity=MatchTeam.class)
	private MatchTeam matchteam;
		
//Association to SEASON
	@ManyToOne(targetEntity = Season.class)
	private Season season;


//Constructor
	public Match() {
		super();
	}
	public Match(String label, Integer status, Place place) {
		super();
		this.label = label;
		this.status = status;
		this.place = place;
	}

	
//Label
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

//Status
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

//Place
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}

//MatchPlayer	
	public MatchPlayer getMatchplayer() {
		return matchplayer;
	}
	public void setMatchplayer(MatchPlayer matchplayer) {
		this.matchplayer = matchplayer;
	}
	
//PlayerStatus
	public PlayerStatus getPlayerstatus() {
		return playerstatus;
	}
	public void setPlayerstatus(PlayerStatus playerstatus) {
		this.playerstatus = playerstatus;
	}
//MatchTeam
	public MatchTeam getMatchteam() {
		return matchteam;
	}
	public void setMatchteam(MatchTeam matchteam) {
		this.matchteam = matchteam;
	}
	
	
}
