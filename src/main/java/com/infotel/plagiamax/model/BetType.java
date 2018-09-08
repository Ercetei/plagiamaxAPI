package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.BetLineContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bettype")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BetType extends DBItem {

	protected String label;
	protected Float initialodds;
	protected Float currentodds;
	protected Integer status;
	protected Integer type;

	@OneToMany(mappedBy = BetLineContract.ASSOCIATION_BETTYPE)
	private List<BetLine> betlines;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public BetType() {
		super();
	}
}
