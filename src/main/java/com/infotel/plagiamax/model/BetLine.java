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

/**
 * The Class BetLine.
 */
@Entity
@Table(name = "betline")
public class BetLine extends DBItem {

	/** The status. 
	 * 
	 * 1. En cours
	 * 2. Gagné
	 * 3. Perdu
	 * 
	 */
	private Integer status;

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
	 * Get the status.
	 * 
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Set the status.
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

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
	 * Instantiates a new bet line.
	 */
	public BetLine() {
		super();
	}
}
