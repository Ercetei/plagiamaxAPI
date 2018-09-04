package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teambet")
public class TeamBet extends BetType{
	
	@ManyToMany(targetEntity=BetType.class)
	private List<BetType> bettype;
	
	public TeamBet() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public List<BetType> getBettype() {
		return bettype;
	}

	public void setBettype(List<BetType> bettype) {
		this.bettype = bettype;
	}

	public TeamBet(List<BetType> bettype, Long id, Float initialodds, Float currentodds, Integer status) {
		super();
		this.bettype = bettype;
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
	}
	
	
	
}
