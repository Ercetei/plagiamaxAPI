package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {

	private Boolean ishometeam;

	@ManyToOne
	@JsonIgnoreProperties({"place", "periods", "stats", "matchteams", "events", "matchbets"})
	private Team team;

	@ManyToOne
	@JsonIgnoreProperties({"place", "matchplayers", "events", "matchteams", "matchday", "matchbets"})
	private Match match;

	public Team getLeftAssociation() {
		return team;
	}

	public void setLeftAssociation(Team team) {
		this.team = team;
	}

	public Match getRightAssociation() {
		return match;
	}

	public void setRightAssociation(Match match) {
		this.match = match;
	}

	public Boolean getIshometeam() {
		return ishometeam;
	}

	public void setIshometeam(Boolean ishometeam) {
		this.ishometeam = ishometeam;
	}

	public MatchTeam() {
		super();
	}
}
