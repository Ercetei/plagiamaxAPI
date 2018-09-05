package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bettype")
@Inheritance(strategy=InheritanceType.JOINED) 
public abstract class BetType extends DBItem {

	protected Float initialodds;
	protected Float currentodds;
	protected Integer status;
	protected Integer type;

	@OneToMany(targetEntity = BetLine.class, mappedBy="bettype")
	private List<BetLine> betlines;

	public BetType() {
		super();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<BetLine> getBetlines() {
		return betlines;
	}

	public void setBetlines(List<BetLine> betlines) {
		this.betlines = betlines;
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

	public BetType(Long id, Float initialodds, Float currentodds, Integer status, Integer type, List<BetLine> betlines) {
		super();
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
		this.type = type;
		this.betlines = betlines;
	}

}
