package com.infotel.plagiamax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Period. Keeps the information of all the times when a player was
 * inside of a specific team.
 */
@Entity
@Table(name = "period")
public class Period extends DBItem {

	/** The player. */
	@ManyToOne
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private Player player;

	/** The team. */
	@ManyToOne
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
	private Team team;

	/** The date when the player came in. */
	@Column(nullable = false)
	private Date startdate;

	/** The date when the player left. */
	private Date enddate;

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
	 * Gets the startdate.
	 *
	 * @return the startdate
	 */
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * Sets the startdate.
	 *
	 * @param startdate the new startdate
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * Gets the enddate.
	 *
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * Sets the enddate.
	 *
	 * @param enddate the new enddate
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	/**
	 * Instantiates a new period.
	 */
	public Period() {
		super();
	}
}
