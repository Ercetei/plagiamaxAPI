package com.infotel.plagiamax.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "matchbet")
public class MatchBet extends BetType {

	@ManyToOne
	private Match match;
	
	@ManyToOne
	private Team team;


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

	public MatchBet() {
		super();
	}
}
