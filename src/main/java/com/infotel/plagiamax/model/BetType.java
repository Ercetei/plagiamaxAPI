package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bettype")
public abstract class BetType extends DBItem {

	protected Float initialodds;
	protected Float currentodds;
	protected Integer status;

	@ManyToOne(targetEntity = BetLine.class)
	private BetLine betline;

	public BetType() {
		super();
	}

	public BetLine getbetline() {
		return betline;
	}

	public void setbetline(BetLine betline) {
		this.betline = betline;
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

	public BetType(Long id, Float initialodds, Float currentodds, Integer status, BetLine betline) {
		super();
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
		this.betline = betline;
	}

}
