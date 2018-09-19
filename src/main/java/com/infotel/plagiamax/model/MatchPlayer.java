package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.model.base.DBItem;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchPlayer.
 */
@Entity
@Table(name = "matchplayer")
public class MatchPlayer extends DBItem {

	/** The enteringtime. */
	private Float enteringtime;
	
	/** The exittime. */
	private Float exittime;

	/** The player. */
	@ManyToOne
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private Player player;

	/** The match. */
	@ManyToOne
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private Match match;

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
	 * Gets the match.
	 *
	 * @return the match
	 */
	public Match getMatch() {
		return match;
	}

	/**
	 * Sets the match.
	 *
	 * @param match the new match
	 */
	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * Gets the enteringtime.
	 *
	 * @return the enteringtime
	 */
	public Float getEnteringtime() {
		return enteringtime;
	}

	/**
	 * Sets the enteringtime.
	 *
	 * @param enteringtime the new enteringtime
	 */
	public void setEnteringtime(Float enteringtime) {
		this.enteringtime = enteringtime;
	}

	/**
	 * Gets the exittime.
	 *
	 * @return the exittime
	 */
	public Float getExittime() {
		return exittime;
	}

	/**
	 * Sets the exittime.
	 *
	 * @param exittime the new exittime
	 */
	public void setExittime(Float exittime) {
		this.exittime = exittime;
	}

	/**
	 * Instantiates a new match player.
	 */
	public MatchPlayer() {
		super();
	}
}
