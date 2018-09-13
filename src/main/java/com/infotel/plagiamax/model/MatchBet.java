package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.TeamContract;

@Entity
@Table(name = "matchbet")
public class MatchBet extends BetType {
	
	@ManyToOne
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private Match match;

	@ManyToOne
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
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
