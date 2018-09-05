package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bet")
public class Bet extends DBItem {

	@ManyToOne(targetEntity = User.class)
	private User user;

	@OneToMany(targetEntity = BetLine.class, mappedBy="bet")
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

	public Bet() {
		super();
	}

	public Bet(Long id, User user, List<BetLine> betlines, String label, Date betdate, Float betamount,
			Integer status) {
		super();
		this.user = user;
		this.betlines = betlines;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
