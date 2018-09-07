package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
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

	@OneToMany(targetEntity = Match.class, mappedBy = MatchContract.ASSOCIATION_PLACE)
	private List<Match> matchs;

	@OneToMany(targetEntity = Player.class, mappedBy = PlayerContract.ASSOCIATION_PLACE)
	private List<Player> players;

	@OneToMany(targetEntity = Team.class, mappedBy = TeamContract.ASSOCIATION_PLACE, fetch = FetchType.LAZY)
	private List<Team> teams;

	@OneToMany(targetEntity = Competition.class, mappedBy = CompetitionContract.ASSOCIATION_PLACE)
	private List<Competition> competitions;

	public Place() {
		super();
	}

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

}
