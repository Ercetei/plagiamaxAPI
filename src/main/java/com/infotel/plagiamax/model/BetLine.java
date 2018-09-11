package com.infotel.plagiamax.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "betline")
public class BetLine extends DBItem {

	private Long momentodds;

	@ManyToOne
	@JsonIgnoreProperties({"betlines", "user"})
	private Bet bet;

	@ManyToOne
	@JsonIgnoreProperties({"betlines"})
	private BetType bettype;

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public BetType getBetType() {
		return bettype;
	}

	public void setBetType(BetType bettype) {
		this.bettype = bettype;
	}

	public Long getMomentodds() {
		return momentodds;
	}

	public void setMomentodds(Long momentodds) {
		this.momentodds = momentodds;
	}
	
	public BetLine() {
		super();
	}
}
