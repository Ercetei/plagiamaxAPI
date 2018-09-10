package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchday")
public class MatchDay extends DBItem {

	private String label;

	@ManyToOne
	private Season season;

	@OneToMany(mappedBy = MatchContract.ASSOCIATION_MATCHDAY)
	@JsonIgnoreProperties({"matchplayers", "events", "matchteams"})
	private List<Match> matchs;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public MatchDay() {
		super();
	}
}
