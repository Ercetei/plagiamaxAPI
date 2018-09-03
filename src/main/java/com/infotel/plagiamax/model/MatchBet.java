package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matchbet")
public class MatchBet {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private Float initialodds;
	private Float currentodds;
	private Integer status;
	public MatchBet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatchBet(Long id, Float initialodds, Float currentodds, Integer status) {
		super();
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getInitialodds() {
		return initialodds;
	}
	public void setInitialodds(Float initialodds) {
		this.initialodds = initialodds;
	}
	public Float getCurrentodds() {
		return currentodds;
	}
	public void setCurrentodds(Float currentodds) {
		this.currentodds = currentodds;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
