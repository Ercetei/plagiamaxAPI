package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "playerstatus")
public class PlayerStatus extends DBItem {

	private Integer status;
	private Float statustime;

//Association a PLAYER
	@ManyToOne(targetEntity = Player.class)
	private Player player;

//Association a MATCH
	@ManyToOne(targetEntity = Match.class)
	private Match match;

//Constructor
	public PlayerStatus() {
		super();
	}

	public PlayerStatus(Long id, Player player, Match match, Integer status, Float statustime) {
		super();
		this.id = id;
		this.player = player;
		this.match = match;
		this.status = status;
		this.statustime = statustime;
	}

//Player
	public Player getLeftAssociation() {
		return player;
	}

	public void setLeftAssociation(Player player) {
		this.player = player;
	}

//Match
	public Match getRightAssociation() {
		return match;
	}

	public void setRightAssociation(Match match) {
		this.match = match;
	}

//Status
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

//StatusTime
	public Float getStatusTime() {
		return statustime;
	}

	public void setStatusTime(Float statustime) {
		this.statustime = statustime;
	}

}
