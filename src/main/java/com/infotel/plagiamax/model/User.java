package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.BetContract;
import com.infotel.plagiamax.model.security.SecurityUser;

@Entity
@Table(name = "user")
public class User extends SecurityUser {

	@OneToMany(targetEntity = Bet.class, mappedBy = BetContract.ASSOCIATION_USER)
	private List<Bet> bets;

	@Column(name = "lastname", nullable = false)
	private String lastname;

	@Column(name = "firstname", nullable = false)
	private String firstname;

	@Column(name = "mail", nullable = false)
	private String mail;

	private Integer wallet;

	@Column(name = "birthdate", nullable = false)
	private Date birthdate;

	public User() {
		super();
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getWallet() {
		return wallet;
	}

	public void setWallet(Integer wallet) {
		this.wallet = wallet;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
