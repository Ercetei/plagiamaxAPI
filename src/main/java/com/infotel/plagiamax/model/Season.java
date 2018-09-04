package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "season")
public class Season extends DBItem {

	@Column(nullable = false)
	private Date startDate;

	@Column(nullable = false)
	private Date endDate;

	@Column(nullable = false)
	private Integer status;

	@ManyToOne(targetEntity = Competition.class)
	private Competition competition;

	@OneToMany(targetEntity = Match.class, mappedBy = MatchContract.ASSOCIATION_TABLE)
	private List<Match> matchs;

	public Season() {
	}

	public Season(Long id, Date startDate, Date endDate, Integer status, Competition competition, List<Match> matchs) {
		super();
		this.setId(id);
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.competition = competition;
		this.matchs = matchs;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

}
