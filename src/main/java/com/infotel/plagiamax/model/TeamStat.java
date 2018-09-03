package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teamstat")
public class TeamStat {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "stat", nullable = false)
	private Stat stat;
	@Column(name = "team", nullable = false)
	private Team team;
	private float value;

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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public TeamStat(Long id, Stat stat, Team team, float value) {
		super();
		this.id = id;
		this.stat = stat;
		this.team = team;
		this.value = value;
	}

	public TeamStat() {
		super();
	}

}
