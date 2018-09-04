package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "team")
public class Team extends DBItem {

	@Column(name = "label", nullable = false)
	private String label;
	@Column(name = "status", nullable = false)
	private Integer status;
	private Date creationdate;
	@OneToMany(targetEntity = Place.class)
	private Place place;
	@OneToOne(targetEntity = Period.class)
	private Period period;
	@OneToMany(targetEntity = Stat.class)
	private List<Stat> stat;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public List<Stat> getStat() {
		return stat;
	}

	public void setStat(List<Stat> stat) {
		this.stat = stat;
	}

	public Team(Long id, String label, Integer status, Date creationdate, Place place, Period period, List<Stat> stat) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.creationdate = creationdate;
		this.place = place;
		this.period = period;
		this.stat = stat;
	}

	public Team() {
		super();
	}

}
