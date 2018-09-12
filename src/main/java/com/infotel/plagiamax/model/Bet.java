package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.BetLineContract;
import com.infotel.plagiamax.contract.UserContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bet")
public class Bet extends DBItem {

	@ManyToOne
	@JsonIgnoreProperties({ UserContract.ASSOCIATION_BET, UserContract.ASSOCIATION_SECURITY_ROLE })
	private User user;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = BetLineContract.ASSOCIATION_BET)
	@JsonIgnoreProperties({ BetLineContract.ASSOCIATION_BET, BetLineContract.ASSOCIATION_BETTYPE })
	private List<BetLine> betlines;

	private String label;
	private Date betdate;
	private Float betamount;
	private Integer status;

	public List<BetLine> getBetlines() {
		return betlines;
	}

	public void setBetlines(List<BetLine> betlines) {
		this.betlines = betlines;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bet() {
		super();
	}
}
