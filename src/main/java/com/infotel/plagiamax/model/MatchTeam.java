package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;
//import com.infotel.plagiamax.contract.TeamContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchteam")
public class MatchTeam extends DBItem {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Boolean ishometeam;
	
//Association a TEAM
	@OneToOne(targetEntity=Team.class
//			,mappedBy=TeamContract.ASSOCIATION_MATCHTEAM
			)
	private Team leftassociation;
	
//Association a MATCH
	@OneToOne(targetEntity=Match.class,mappedBy=MatchContract.ASSOCIATION_MATCHTEAM)
	private Match rightassociation;
	
	
//Constructor
	public MatchTeam() {
		super();
	}
	public MatchTeam(Team leftassociation, Match rightassociation, Boolean ishometeam) {
		super();
		this.leftassociation = leftassociation;
		this.rightassociation = rightassociation;
		this.ishometeam = ishometeam;
	}
	

//Team
	public Team getLeftAssociation() {
		return leftassociation;
	}
	public void setLeftAssociation(Team leftassociation) {
		this.leftassociation = leftassociation;
	}
	
//Match
	public Match getRightAssociation() {
		return rightassociation;
	}
	public void setRightAssociation(Match rightassociation) {
		this.rightassociation = rightassociation;
	}

//IsHomeTeam
	public Boolean getIshometeam() {
		return ishometeam;
	}
	public void setIshometeam(Boolean ishometeam) {
		this.ishometeam = ishometeam;
	}
	
}
