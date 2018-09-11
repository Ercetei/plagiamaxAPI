package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.BetContract;
import com.infotel.plagiamax.contract.BetTypeContract;
import com.infotel.plagiamax.contract.MatchBetContract;
import com.infotel.plagiamax.contract.PlayerBetContract;
import com.infotel.plagiamax.contract.TeamBetContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "betline")
public class BetLine extends DBItem {

	private Long momentodds;

	@ManyToOne
	@JsonIgnoreProperties({ BetContract.ASSOCIATION_BETLINE, BetContract.ASSOCIATION_USER })
	private Bet bet;

	@ManyToOne
	@JsonIgnoreProperties({ BetTypeContract.ASSOCIATION_BETLINE, MatchBetContract.ASSOCIATION_MATCH,
			MatchBetContract.ASSOCIATION_TEAM, TeamBetContract.ASSOCIATION_TEAM, PlayerBetContract.ASSOCIATION_PLAYER })
	private BetType bettype;

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public BetType getBettype() {
		return bettype;
	}

	public void setBettype(BetType bettype) {
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
