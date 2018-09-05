package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "place")
public class Place extends DBItem {

	private String country;
	private String city;
	private String stadium;

//Association to MATCH
	@OneToMany(targetEntity = Match.class, mappedBy="place")
	private List<Match> match;

//Association to PLAYER
	@OneToMany(targetEntity = Player.class, mappedBy="place")
	private List<Player> player;

//Association to TEAM
	@OneToMany(targetEntity = Team.class, mappedBy="place")
	private List<Team> team;

//Association to COMPETITION
	@OneToMany(targetEntity = Competition.class, mappedBy="place")
	private List<Competition> competitions;

	public Place() {
		super();
	}

	public Place(String country, String city, String stadium, List<Match> match, List<Player> player, List<Team> team,
			List<Competition> competitions) {
		super();
		this.country = country;
		this.city = city;
		this.stadium = stadium;
		this.match = match;
		this.player = player;
		this.team = team;
		this.competitions = competitions;
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

	public List<Match> getMatch() {
		return match;
	}

	public void setMatch(List<Match> match) {
		this.match = match;
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

}
