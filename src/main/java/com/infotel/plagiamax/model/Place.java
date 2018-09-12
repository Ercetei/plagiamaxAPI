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

@Entity
@Table(name = "place")
public class Place extends DBItem {

	private String country;
	private String city;
	private String stadium;

	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = MatchContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private List<Match> matchs;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = PlayerContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private List<Player> players;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = TeamContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ TeamContract.ASSOCIATION_EVENT, TeamContract.ASSOCIATION_MATCHBET,
			TeamContract.ASSOCIATION_MATCHTEAM, TeamContract.ASSOCIATION_PERIOD, TeamContract.ASSOCIATION_PLACE,
			TeamContract.ASSOCIATION_STATS })
	private List<Team> teams;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = CompetitionContract.ASSOCIATION_PLACE)
	@JsonIgnoreProperties({ CompetitionContract.ASSOCIATION_CATEGORY, CompetitionContract.ASSOCIATION_PLACE,
			CompetitionContract.ASSOCIATION_SEASON })
	private List<Competition> competitions;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public Place() {
		super();
	}
}
