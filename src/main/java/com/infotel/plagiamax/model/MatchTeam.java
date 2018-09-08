package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {

	private Boolean ishometeam;

	@ManyToOne
	private Team team;

	@ManyToOne
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
