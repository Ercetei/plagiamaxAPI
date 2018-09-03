package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stat")
public class Stat {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "label", nullable = false)
	private String label;
	private Stat parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Stat(Long id, String label, Stat parent) {
		super();
		this.id = id;
		this.label = label;
		this.parent = parent;
	}

	public Stat() {
		super();
	}

}
