package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.CompetitionContract;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Place. Specifies a place, can be a country, a city and / or a
 * stadium
 */
@Entity
@Table(name = "place")
public class Place extends DBItem {

	/** The country. */
	private String country;

	/** The city. */
	private String city;

	/** The stadium. */
	private String stadium;

	/** The matchs. */
	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = MatchContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private List<Match> matchs;

	/** The players. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = PlayerContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private List<Player> players;

	/** The teams. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = TeamContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
	private List<Team> teams;

	/** The competitions. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = CompetitionContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ CompetitionContract.ASSOCIATION_CATEGORY, CompetitionContract.ASSOCIATION_PLACE,
			CompetitionContract.ASSOCIATION_SEASON })
	private List<Competition> competitions;

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the stadium.
	 *
	 * @return the stadium
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * Sets the stadium.
	 *
	 * @param stadium the new stadium
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	/**
	 * Gets the matchs.
	 *
	 * @return the matchs
	 */
	public List<Match> getMatchs() {
		return matchs;
	}

	/**
	 * Sets the matchs.
	 *
	 * @param matchs the new matchs
	 */
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * Sets the teams.
	 *
	 * @param teams the new teams
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	/**
	 * Gets the competitions.
	 *
	 * @return the competitions
	 */
	public List<Competition> getCompetitions() {
		return competitions;
	}

	/**
	 * Sets the competitions.
	 *
	 * @param competitions the new competitions
	 */
	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	/**
	 * Instantiates a new place.
	 */
	public Place() {
		super();
	}
}
