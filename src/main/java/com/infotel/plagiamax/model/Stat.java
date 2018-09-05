package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "stat")
public class Stat extends DBItem {

	@Column(name = "label", nullable = false)
	private String label;
	private Float value;
	
	@ManyToOne(targetEntity=Stat.class)
	@JsonManagedReference
	private Stat parent;
	
	@OneToMany(targetEntity=Stat.class)
	@JsonBackReference
	private List<Stat> children;
	
	@ManyToOne(targetEntity = Team.class)
	@JsonManagedReference
	private Team team;
	
	@ManyToOne(targetEntity = Player.class)
	@JsonManagedReference
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

	public Stat(Long id, String label, Float value, Stat parent, List<Stat> children, Team team, Player player) {
		super();
		this.id = id;
		this.label = label;
		this.value = value;
		this.parent = parent;
		this.children = children;
		this.team = team;
		this.player = player;
	}

	public Stat() {
		super();
	}

}
