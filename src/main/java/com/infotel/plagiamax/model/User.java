package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.BetContract;
import com.infotel.plagiamax.model.security.SecurityUser;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "user")
public class User extends SecurityUser {

	/** The bets. */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = BetContract.ASSOCIATION_USER)
	@JsonIgnoreProperties({ BetContract.ASSOCIATION_USER, BetContract.ASSOCIATION_BETLINE })
	private List<Bet> bets;

	/** The lastname. */
	@Column(nullable = false)
	private String lastname;

	/** The firstname. */
	@Column(nullable = false)
	private String firstname;

	/** The mail. */
	@Column(nullable = false)
	private String mail;

	/** The wallet. */
	private Double wallet;

	/** The birthdate. */
	@Column(nullable = false)
	private Date birthdate;

	/**
	 * Gets the bets.
	 *
	 * @return the bets
	 */
	public List<Bet> getBets() {
		return bets;
	}

	/**
	 * Sets the bets.
	 *
	 * @param bets the new bets
	 */
	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the wallet.
	 *
	 * @return the wallet
	 */
	public Double getWallet() {
		return wallet;
	}

	/**
	 * Sets the wallet.
	 *
	 * @param amountWin the new wallet
	 */
	public void setWallet(Double amountWin) {
		this.wallet = amountWin;
	}

	/**
	 * Gets the birthdate.
	 *
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Sets the birthdate.
	 *
	 * @param birthdate the new birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}
}
