package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "playerbet")
public class PlayerBet extends BetType {

	@ManyToOne
	@JsonIgnoreProperties({"periods", "place", "stats", "matchplayers", "events", "playersbets"})
	private Player player;

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

	public PlayerBet() {
		super();
	}
}
