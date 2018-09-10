package com.infotel.plagiamax.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.infotel.plagiamax.contract.MatchDayContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "season")
public class Season extends DBItem {

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date endDate;

	@Column(nullable = false)
	private Integer status;

	@ManyToOne
	private Competition competition;

	@OneToMany(mappedBy = MatchDayContract.ASSOCIATION_SEASON)
	private List<MatchDay> matchdays;

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

	public List<MatchDay> getMatchdays() {
		return matchdays;
	}

	public void setMatchdays(List<MatchDay> matchdays) {
		this.matchdays = matchdays;
	}

	public Season() {
		super();
	}
}
