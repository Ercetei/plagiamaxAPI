package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.CompetitionContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "category")
public class Category extends DBItem {

	@Column(nullable = false)
	private String label;

	@Column(nullable = false)
	private Integer status;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JsonIgnoreProperties({ CompetitionContract.ASSOCIATION_CATEGORY, CompetitionContract.ASSOCIATION_PLACE,
			CompetitionContract.ASSOCIATION_SEASON })
	private List<Competition> competitions;

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

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public Category() {
		super();
	}
}
