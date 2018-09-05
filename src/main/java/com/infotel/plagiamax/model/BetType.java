package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bettype")
public abstract class BetType extends DBItem {

	protected Float initialodds;
	protected Float currentodds;
	protected Integer status;

	@OneToMany(targetEntity = BetLine.class, mappedBy="bettype")
	private List<BetLine> betlines;

	public BetType() {
		super();
	}

	public List<BetLine> getbetlines() {
		return betlines;
	}

	public void setbetline(List<BetLine> betlines) {
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

	public BetType(Long id, Float initialodds, Float currentodds, Integer status, List<BetLine> betlines) {
		super();
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
		this.betlines = betlines;
	}

}
