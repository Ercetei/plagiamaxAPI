package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer extends DBItem {

	private Float enteringtime;
	private Float exittime;

	@ManyToOne
	@JsonIgnoreProperties({"place", "periods", "stats","matchplayers", "events", "playersbets"})
	private Player player;

	@ManyToOne
	@JsonIgnoreProperties({"place", "matchplayers", "events", "matchteams", "matchday", "matchbets"})
	private Match match;

	public Player getLeftAssociation() {
		return player;
	}

	public void setLeftAssociation(Player player) {
		this.player = player;
	}

	public Match getRightAssociation() {
		return match;
	}

	public void setRightAssociation(Match match) {
		this.match = match;
	}

	public Float getEnteringtime() {
		return enteringtime;
	}

	public void setEnteringtime(Float enteringtime) {
		this.enteringtime = enteringtime;
	}

	public Float getExittime() {
		return exittime;
	}

	public void setExittime(Float exittime) {
		this.exittime = exittime;
	}

	public MatchPlayer() {
		super();
	}
}
