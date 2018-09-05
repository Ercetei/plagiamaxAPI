package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {

	private Boolean ishometeam;

//Association a TEAM
	@ManyToOne(targetEntity = Team.class)
	@JsonManagedReference
	private Team team;

//Association a MATCH
	@ManyToOne(targetEntity = Match.class)
	@JsonManagedReference
	private Match match;

//Constructor
	public MatchTeam() {
		super();
	}

	public MatchTeam(Long id, Team team, Match match, Boolean ishometeam) {
		super();
		this.id = id;
		this.team = team;
		this.match = match;
		this.ishometeam = ishometeam;
	}

//Team
	public Team getLeftAssociation() {
		return team;
	}

	public void setLeftAssociation(Team team) {
		this.team = team;
	}

//Match
	public Match getRightAssociation() {
		return match;
	}

	public void setRightAssociation(Match match) {
		this.match = match;
	}

//IsHomeTeam
	public Boolean getIshometeam() {
		return ishometeam;
	}

	public void setIshometeam(Boolean ishometeam) {
		this.ishometeam = ishometeam;
	}

}
