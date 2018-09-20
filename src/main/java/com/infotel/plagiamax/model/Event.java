package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
@Entity
@Table(name = "event")
public class Event extends DBItem {

	/** The status. 
	 * 
	 * 1. BUT
	 * 2. Carton jaune
	 * 3. Carton rouge
	 * 4. Blessure
	 * 5. Penalty
	 * 
	 */
	private Integer status;
	
	/** The statustime. */
	private Float statustime;

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

	/** The team. */
	@ManyToOne
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
	private Team team;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the statustime.
	 *
	 * @return the statustime
	 */
	public Float getStatustime() {
		return statustime;
	}

	/**
	 * Sets the statustime.
	 *
	 * @param statustime the new statustime
	 */
	public void setStatustime(Float statustime) {
		this.statustime = statustime;
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
	 * Gets the team.
	 *
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Sets the team.
	 *
	 * @param team the new team
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * Instantiates a new event.
	 */
	public Event() {
		super();
	}
}
