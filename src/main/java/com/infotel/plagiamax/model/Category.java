package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.CompetitionContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "category")
public class Category extends DBItem {

	@Column(nullable = false)
	private String label;

	@Column(nullable = false)
	private Integer status;

	@OneToMany(targetEntity = Competition.class, mappedBy = CompetitionContract.ID)
	private List<Competition> competitions;

	public Category() {
	}

	public Category(Long id, String label, Integer status, List<Competition> competitions) {
		super();
		this.setId(id);
		this.label = label;
		this.status = status;
		this.competitions = competitions;
	}

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

	
}
