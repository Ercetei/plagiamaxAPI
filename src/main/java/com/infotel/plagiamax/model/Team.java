package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne(targetEntity = Place.class)
	private Place place;
	
	@OneToMany(targetEntity = Period.class, mappedBy="team")
	private List<Period> periods;
	
	@OneToMany(targetEntity = Stat.class, mappedBy="team")
	private List<Stat> stats;

//Association to MATCHTEAM
	@OneToMany(targetEntity = MatchTeam.class, mappedBy="team")
	private List<MatchTeam> matchteams;

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

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public List<MatchTeam> getMatchteams() {
		return matchteams;
	}

	public void setMatchteams(List<MatchTeam> matchteams) {
		this.matchteams = matchteams;
	}

	public Team(Long id, String label, Integer status, Date creationdate, Place place, List<Period> periods, List<Stat> stats,
			List<MatchTeam> matchteams) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.creationdate = creationdate;
		this.place = place;
		this.periods = periods;
		this.stats = stats;
		this.matchteams = matchteams;
	}

	public Team() {
		super();
	}

	

	

}
