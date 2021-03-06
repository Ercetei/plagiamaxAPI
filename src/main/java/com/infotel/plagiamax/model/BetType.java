package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.BetLineContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class BetType. Is the parent of MatchBet, PlayerBet and TeamBet which the
 * users can select and put money on.
 */
@Entity
@Table(name = "bettype")
@Inheritance(strategy = InheritanceType.JOINED)
public class BetType extends DBItem {

	/** The label of the bet. */
	protected String label;

	/** The odds when they are generated. */
	protected Double initialodds;

	/** The odds that evolve with the amount of users betting on each side. */
	protected Double currentodds;

	/**
	 * The status, to know which ones you can still bet on. (Useful for a match in
	 * progress for example)
	 * 
	 * 1 : In progress. 
	 * 2 : Closed.
	 * 
	 */
	protected Integer status;

	/**
	 * The type of the bet, to know how the program has to interprete them.
	 * 
	 * 1. Winner 
	 * 2. Exact Score 
	 * 3. Goals
	 * 
	 */
	protected Integer type;

	/** The betlines. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = BetLineContract.ASSOCIATION_BETTYPE)
	@JsonIgnoreProperties({ BetLineContract.ASSOCIATION_BET, BetLineContract.ASSOCIATION_BETTYPE })
	protected List<BetLine> betlines;

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Gets the betlines.
	 *
	 * @return the betlines
	 */
	public List<BetLine> getBetlines() {
		return betlines;
	}

	/**
	 * Sets the betlines.
	 *
	 * @param betlines the new betlines
	 */
	public void setBetlines(List<BetLine> betlines) {
		this.betlines = betlines;
	}

	/**
	 * Gets the initialodds.
	 *
	 * @return the initialodds
	 */
	public Double getInitialodds() {
		return initialodds;
	}

	/**
	 * Sets the initialodds.
	 *
	 * @param initialodds the new initialodds
	 */
	public void setInitialodds(Double initialodds) {
		this.initialodds = initialodds;
	}

	/**
	 * Gets the currentodds.
	 *
	 * @return the currentodds
	 */
	public Double getCurrentodds() {
		return currentodds;
	}

	/**
	 * Sets the currentodds.
	 *
	 * @param currentodds the new currentodds
	 */
	public void setCurrentodds(Double currentodds) {
		this.currentodds = currentodds;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Instantiates a new bet type.
	 */
	public BetType() {
		super();
	}
}
