package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="playerbet")
public class PlayerBet extends BetType {
	
	@ManyToOne(targetEntity=Player.class)
	@JsonManagedReference
	private Player player;
	
	public PlayerBet() {
		super();
	}

	public PlayerBet(Player player) {
		super();
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	

	
}
