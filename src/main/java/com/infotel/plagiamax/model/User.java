package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "user")
public class User extends DBItem {
	
	@OneToMany(targetEntity=Bet.class, mappedBy = "user")
	@JsonBackReference
	private List<Bet> bets;

	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "mail", nullable = false)
	private String mail;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "username", nullable = false)
	private String username;
	private Integer wallet;
	private String creditcard;
	private String expirationdate;
	private String cryptogram;
	
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;
	
	
	public User() {
		super();
	}

	public User(Long id, List<Bet> bets, String lastname, String firstname, String mail, String password,
			String username, Integer wallet, String creditcard, String expirationdate, String cryptogram,
			Date birthdate) {
		super();
		this.bets = bets;
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.wallet = wallet;
		this.creditcard = creditcard;
		this.expirationdate = expirationdate;
		this.cryptogram = cryptogram;
		this.birthdate = birthdate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getWallet() {
		return wallet;
	}

	public void setWallet(Integer wallet) {
		this.wallet = wallet;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

}
