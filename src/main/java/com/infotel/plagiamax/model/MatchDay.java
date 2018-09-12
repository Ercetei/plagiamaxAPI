package com.infotel.plagiamax.model;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.SeasonContract;
>>>>>>> ca48d15fe7c5c4779673b84a5f9029f12b5541a7
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchday")
public class MatchDay extends DBItem {
<<<<<<< HEAD
	
	private String label;
	
	//Association to Season
		@ManyToOne(targetEntity = Player.class)
		@JsonManagedReference
		private Player player;

	//Association to MATCH
		@ManyToOne(targetEntity = Match.class)
		@JsonManagedReference
		private Match match;

=======

	private String label;

	@ManyToOne
	@JsonIgnoreProperties({ SeasonContract.ASSOCIATION_MATCHDAY })
	private Season season;

	@OneToMany(mappedBy = MatchContract.ASSOCIATION_MATCHDAY, cascade = { CascadeType.REMOVE })
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
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
>>>>>>> ca48d15fe7c5c4779673b84a5f9029f12b5541a7
}
