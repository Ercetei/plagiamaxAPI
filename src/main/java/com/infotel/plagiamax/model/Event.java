package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "event")
public class Event extends DBItem {

	private Integer status;
	private Float statustime;

//Association a PLAYER
	@ManyToOne(targetEntity = Player.class)
	@JsonManagedReference
	private Player player;

//Association a MATCH
	@ManyToOne(targetEntity = Match.class)
	@JsonManagedReference
	private Match match;
	
	@ManyToOne(targetEntity = Team.class)
	private Team team;

//Constructor
	public Event() {
		super();
	}

//Status
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getStatustime() {
		return statustime;
	}

	public void setStatustime(Float statustime) {
		this.statustime = statustime;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	
}
