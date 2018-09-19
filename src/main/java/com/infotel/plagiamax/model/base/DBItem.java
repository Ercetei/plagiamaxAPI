package com.infotel.plagiamax.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// TODO: Auto-generated Javadoc
/**
 * The Class DBItem.
 */
@MappedSuperclass
public abstract class DBItem {

	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
