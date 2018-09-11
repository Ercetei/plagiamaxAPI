package com.infotel.plagiamax.model.security;

import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.converter.CryptoConverter;
import com.infotel.plagiamax.model.base.DBItem;

// If abstract
@MappedSuperclass
@Inheritance
//@Entity
//@Table(name = "security_user")
public abstract class SecurityUser extends DBItem {

	private String username;
	@Convert(converter = CryptoConverter.class)
	private String password;
	private Boolean status;

	@ManyToMany(targetEntity = SecurityRole.class)
	@JoinTable(name = "users_securityroles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnoreProperties({ "users" })
	private Set<SecurityRole> roles;

	@Convert(converter = CryptoConverter.class)
	private String creditcard;

	@Convert(converter = CryptoConverter.class)
	private String expirationdate;

	@Convert(converter = CryptoConverter.class)
	private String cryptogram;

	/**
	 * @return the login
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param login the login to set
	 */
	public void setUsername(String login) {
		this.username = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enable
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the roles
	 */
	public Set<SecurityRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<SecurityRole> roles) {
		this.roles = roles;
	}

	public SecurityUser() {
	}
}
