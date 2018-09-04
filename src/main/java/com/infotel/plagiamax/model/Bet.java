package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bet")
public class Bet {
	
	@OneToOne(targetEntity=User.class)
	private Collection<User> users;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String label;
	private Date betdate;
	private Float betamount;
	private Integer status;
	public Bet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bet(Long id, String label, Date betdate, Float betamount, Integer status) {
		super();
		this.id = id;
		this.label = label;
		this.betdate = betdate;
		this.betamount = betamount;
		this.status = status;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getBetdate() {
		return betdate;
	}
	public void setBetdate(Date betdate) {
		this.betdate = betdate;
	}
	public Float getBetamount() {
		return betamount;
	}
	public void setBetamount(Float betamount) {
		this.betamount = betamount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
