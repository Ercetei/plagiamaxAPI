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

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityUser.
 */
// If abstract
@MappedSuperclass
@Inheritance
//@Entity
//@Table(name = "security_user")
public abstract class SecurityUser extends DBItem {

	/** The username. */
	private String username;
	
	/** The password. */
	@Convert(converter = CryptoConverter.class)
	private String password;
	
	/** The enable. */
	private Boolean enable;

	/** The roles. */
	@ManyToMany(targetEntity = SecurityRole.class)
	@JoinTable(name = "users_securityroles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnoreProperties({ "users" })
	private Set<SecurityRole> roles;

	/** The creditcard. */
	@Convert(converter = CryptoConverter.class)
	private String creditcard;

	/** The expirationdate. */
	@Convert(converter = CryptoConverter.class)
	private String expirationdate;

	/** The cryptogram. */
	@Convert(converter = CryptoConverter.class)
	private String cryptogram;

	/**
	 * Gets the username.
	 *
	 * @return the login
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param login the login to set
	 */
	public void setUsername(String login) {
		this.username = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the enable.
	 *
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * Sets the enable.
	 *
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<SecurityRole> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the roles to set
	 */
	public void setRoles(Set<SecurityRole> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the creditcard.
	 *
	 * @return the creditcard
	 */
	public String getCreditcard() {
		return creditcard;
	}

	/**
	 * Sets the creditcard.
	 *
	 * @param creditcard the new creditcard
	 */
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	/**
	 * Gets the expirationdate.
	 *
	 * @return the expirationdate
	 */
	public String getExpirationdate() {
		return expirationdate;
	}

	/**
	 * Sets the expirationdate.
	 *
	 * @param expirationdate the new expirationdate
	 */
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	/**
	 * Gets the cryptogram.
	 *
	 * @return the cryptogram
	 */
	public String getCryptogram() {
		return cryptogram;
	}

	/**
	 * Sets the cryptogram.
	 *
	 * @param cryptogram the new cryptogram
	 */
	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	/**
	 * Instantiates a new security user.
	 */
	public SecurityUser() {
		super();
	}
}
