package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teambet")
public class TeamBet extends BetType {

	@ManyToOne
	@JsonIgnoreProperties({"place", "periods", "stats", "matchteams", "events", "matchbets"})
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamBet() {
		super();
	}
}
