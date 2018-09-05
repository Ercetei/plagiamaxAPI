package com.infotel.plagiamax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "period")
public class Period extends DBItem {

	@OneToOne(targetEntity = Player.class, mappedBy="period")
	private Player player;
	
	@OneToOne(targetEntity = Team.class, mappedBy="period")
	private Team team;
	
	@Column(name = "startdate", nullable = false)
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

	public Period(Long id, Player player, Team team, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.player = player;
		this.team = team;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Period() {
		super();
	}
}
