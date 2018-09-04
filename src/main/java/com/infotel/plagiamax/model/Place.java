package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "place")
public class Place extends DBItem {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private String country;
	private String city;
	private String stadium;
	
//Association to MATCH
	@ManyToOne(targetEntity=Match.class)
	private Match match;
	
//Association to PLAYER
	@OneToMany(targetEntity=Player.class)
	private Player player;
	
//Association to TEAM
	@OneToMany(targetEntity=Team.class)
	private Team team;
	
//Association to COMPETITION
	@OneToOne(targetEntity=Competition.class)
	private Competition competition;
	
	
//Constructor	
	public Place() {
		super();
	}
	public Place(String country, String city, String stadium) {
		super();
		this.country = country;
		this.city = city;
		this.stadium = stadium;
	}


//Country
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

//City
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
//Stadium
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	
//Match
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
//Player
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
//Team
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
		
	
}
