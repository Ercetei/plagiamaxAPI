package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {

	private Boolean ishometeam;

//Association a TEAM
	@OneToOne(targetEntity = Team.class, mappedBy = TeamContract.ASSOCIATION_MATCHTEAM)
	private Team team;

//Association a MATCH
	@OneToOne(targetEntity = Match.class, mappedBy = MatchContract.ASSOCIATION_MATCHTEAM)
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
