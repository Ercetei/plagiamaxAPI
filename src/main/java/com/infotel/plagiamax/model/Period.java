package com.infotel.plagiamax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "period")
public class Period extends DBItem {

	@ManyToOne
	@JsonIgnoreProperties({"place", "periods", "stats","matchplayers", "events", "playersbets"})
	private Player player;
	
	@ManyToOne
	@JsonIgnoreProperties({"place", "periods", "stats", "matchteams", "events", "matchbets"})
	private Team team;
	
	@Column(nullable = false)
	private Date startdate;
	private Date enddate;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Period() {
		super();
	}
}
