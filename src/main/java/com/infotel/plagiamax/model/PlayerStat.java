package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "playerstat")
public class PlayerStat {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "stat", nullable = false)
	private Stat stat;
	@Column(name = "player", nullable = false)
	private Player player;
	private Float value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public PlayerStat(Long id, Stat stat, Player player, Float value) {
		super();
		this.id = id;
		this.stat = stat;
		this.player = player;
		this.value = value;
	}

	public PlayerStat() {
		super();
	}

}
