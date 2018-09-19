package com.infotel.plagiamax.model.security;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.UserContract;
import com.infotel.plagiamax.model.User;
import com.infotel.plagiamax.model.base.DBItem;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityRole.
 */
@Entity
@Table(name = "security_role")
public class SecurityRole extends DBItem {

	/** The role. */
	private String role;

	/** The users. */
	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "users_securityroles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnoreProperties({ UserContract.ASSOCIATION_BET, UserContract.ASSOCIATION_SECURITY_ROLE })
	private Set<User> users;

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * Instantiates a new security role.
	 */
	public SecurityRole() {
	}
}
