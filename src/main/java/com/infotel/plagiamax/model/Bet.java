package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bet")
public class Bet extends DBItem{
	
	@ManyToOne(targetEntity=User.class)
	private User users;
	
	@OneToOne(targetEntity=BetLine.class)
	private BetLine BetLineAssociation;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String label;
	private Date betdate;
	private Float betamount;
	private Integer status;
	
	public BetLine getBetLineAssociation() {
		return BetLineAssociation;
	}
	public void setBetLineAssociation(BetLine betLineAssociation) {
		BetLineAssociation = betLineAssociation;
	}
	
	public Bet() {
		super();
	}
	
	public Bet(User users, BetLine betLineAssociation, Long id, String label, Date betdate, Float betamount,
			Integer status) {
		super();
		this.users = users;
		BetLineAssociation = betLineAssociation;
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
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
		
}
