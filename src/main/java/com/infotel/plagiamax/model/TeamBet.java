package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.TeamContract;

@Entity
@Table(name = "teambet")
public class TeamBet extends BetType {

	@ManyToOne
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
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
