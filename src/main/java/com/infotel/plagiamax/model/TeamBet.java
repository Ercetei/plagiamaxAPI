package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teambet")
public class TeamBet extends BetType{
	
	@ManyToOne(targetEntity=Team.class)
	private Team team;
	
	public TeamBet() {
		super();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamBet(Team team) {
		super();
		this.team = team;
	}
	
}
