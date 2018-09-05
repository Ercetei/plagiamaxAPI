package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="playerbet")
public class PlayerBet extends BetType {
	
	@ManyToOne(targetEntity=Player.class)
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
