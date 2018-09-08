package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "stat")
public class Stat extends DBItem {

	@Column(nullable = false)
	private String label;
	private Float value;
	
	@ManyToOne
	private Stat parent;
	
	@OneToMany
	private List<Stat> children;
	
	@ManyToOne
	private Team team;
	
	@ManyToOne
	private Player player;

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Stat> getChildren() {
		return children;
	}

	public void setChildren(List<Stat> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Stat getParent() {
		return parent;
	}

	public void setParent(Stat parent) {
		this.parent = parent;
	}

	public Stat() {
		super();
	}
}
