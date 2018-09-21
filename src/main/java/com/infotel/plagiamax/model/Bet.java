package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.BetLineContract;
import com.infotel.plagiamax.contract.UserContract;
import com.infotel.plagiamax.model.base.DBItem;

/**
 * The Class Bet.
 */
@Entity
@Table(name = "bet")
public class Bet extends DBItem {

	/** The user. */
	@ManyToOne
	@JsonIgnoreProperties({ UserContract.ASSOCIATION_BET, UserContract.ASSOCIATION_SECURITY_ROLE })
	private User user;

	/** The betlines. */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = BetLineContract.ASSOCIATION_BET)
	@JsonIgnoreProperties({ BetLineContract.ASSOCIATION_BET })
	private List<BetLine> betlines;
	
	/** The betdate. */
	private Date betdate;
	
	/** The betamount. */
	private Float betamount;
	
	/** The status. 
	 * 
	 * 1. En cours
	 * 2. Gagné
	 * 3. Perdu
	 * 
	 * */
	@Column(columnDefinition="int default 1")
	private Integer status;

	/** The momentodds. */
	private Float momentodds;
	
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getid() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setid(Long id) {
		this.id = id;
	}

	/**
	 * Gets the betdate.
	 *
	 * @return the betdate
	 */
	public Date getBetdate() {
		return betdate;
	}

	/**
	 * Sets the betdate.
	 *
	 * @param betdate the new betdate
	 */
	public void setBetdate(Date betdate) {
		this.betdate = betdate;
	}

	/**
	 * Gets the betamount.
	 *
	 * @return the betamount
	 */
	public Float getBetamount() {
		return betamount;
	}

	/**
	 * Sets the betamount.
	 *
	 * @param betamount the new betamount
	 */
	public void setBetamount(Float betamount) {
		this.betamount = betamount;
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
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Gets the momentodds.
	 *
	 * @return the momentodds
	 */
	public Float getMomentodds() {
		return momentodds;
	}

	/**
	 * Sets the momentodds.
	 *
	 * @param momentodds the new momentodds
	 */
	public void setMomentodds(Float momentodds) {
		this.momentodds = momentodds;
	}

	/**
	 * Instantiates a new bet.
	 */
	public Bet() {
		super();
	}
}
