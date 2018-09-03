package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(name = "label", nullable = false)
	private String label;
	@Column(name = "status", nullable = false)
	private Integer status;
	private Date creationdate;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Team(Long id, String label, Integer status, Date creationdate) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.creationdate = creationdate;
	}

	public Team() {
		super();
	}

}
