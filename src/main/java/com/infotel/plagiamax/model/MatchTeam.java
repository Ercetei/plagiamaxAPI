package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

// TODO: Auto-generated Javadoc
/**
 * The Class MatchTeam.
 */
@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {

	/** The ishometeam. */
	private Boolean ishometeam;

	/** The team. */
	@ManyToOne
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
	private Team team;

	/** The match. */
	@ManyToOne
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private Match match;

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
	 * Gets the ishometeam.
	 *
	 * @return the ishometeam
	 */
	public Boolean getIshometeam() {
		return ishometeam;
	}

	/**
	 * Sets the ishometeam.
	 *
	 * @param ishometeam the new ishometeam
	 */
	public void setIshometeam(Boolean ishometeam) {
		this.ishometeam = ishometeam;
	}

	/**
	 * Instantiates a new match team.
	 */
	public MatchTeam() {
		super();
	}
}
