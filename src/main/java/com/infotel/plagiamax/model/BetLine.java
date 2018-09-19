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

// TODO: Auto-generated Javadoc
/**
 * The Class BetLine.
 */
@Entity
@Table(name = "betline")
public class BetLine extends DBItem {

	/** The momentodds. */
	private Long momentodds;

	/** The bet. */
	@ManyToOne
	@JsonIgnoreProperties({ BetContract.ASSOCIATION_BETLINE, BetContract.ASSOCIATION_USER })
	private Bet bet;

	/** The bettype. */
	@ManyToOne
	@JsonIgnoreProperties({ BetTypeContract.ASSOCIATION_BETLINE, MatchBetContract.ASSOCIATION_MATCH,
			MatchBetContract.ASSOCIATION_TEAM, TeamBetContract.ASSOCIATION_TEAM, PlayerBetContract.ASSOCIATION_PLAYER })
	private BetType bettype;

	/**
	 * Gets the bet.
	 *
	 * @return the bet
	 */
	public Bet getBet() {
		return bet;
	}

	/**
	 * Sets the bet.
	 *
	 * @param bet the new bet
	 */
	public void setBet(Bet bet) {
		this.bet = bet;
	}

	/**
	 * Gets the bettype.
	 *
	 * @return the bettype
	 */
	public BetType getBettype() {
		return bettype;
	}

	/**
	 * Sets the bettype.
	 *
	 * @param bettype the new bettype
	 */
	public void setBettype(BetType bettype) {
		this.bettype = bettype;
	}

	/**
	 * Gets the momentodds.
	 *
	 * @return the momentodds
	 */
	public Long getMomentodds() {
		return momentodds;
	}

	/**
	 * Sets the momentodds.
	 *
	 * @param momentodds the new momentodds
	 */
	public void setMomentodds(Long momentodds) {
		this.momentodds = momentodds;
	}

	/**
	 * Instantiates a new bet line.
	 */
	public BetLine() {
		super();
	}
}
