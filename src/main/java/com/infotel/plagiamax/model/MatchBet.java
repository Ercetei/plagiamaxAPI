package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchbet")
public class MatchBet extends BetType {

	@ManyToOne(targetEntity = Match.class)
	private Match match;

	public MatchBet() {
		super();
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public MatchBet(Long id, Match match, Float initialodds, Float currentodds, Integer status) {
		super();
		this.id = id;
		this.match = match;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
	}

}
