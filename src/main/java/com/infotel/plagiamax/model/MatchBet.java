package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "matchbet")
public class MatchBet extends BetType {

	@ManyToOne(targetEntity = Match.class)
	@JsonManagedReference
	private Match match;
	
	@ManyToMany(targetEntity = Team.class)
	private List<Team> teams;

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
