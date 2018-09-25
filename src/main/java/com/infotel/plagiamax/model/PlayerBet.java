package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.PlayerContract;

/**
 * The Class PlayerBet. Extends the class BetType, all the infos about the bet
 * are inside of it. Corresponds to a player.
 */
@Entity
@Table(name = "playerbet")
public class PlayerBet extends BetType {

	/** The player. */
	@ManyToOne
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private Player player;

	/**
	 * Instantiates a new player bet.
	 *
	 * @param player the player
	 */
	public PlayerBet(Player player) {
		super();
		this.player = player;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Instantiates a new player bet.
	 */
	public PlayerBet() {
		super();
	}
}
