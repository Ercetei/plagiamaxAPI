package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;
//import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "playerstatus")
public class PlayerStatus extends DBItem {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer status;
	private Float statustime;
	
//Association a PLAYER
	@OneToOne(targetEntity=Player.class
//			,mappedBy=PlayerContract.ASSOCIATION_PLAYERSTATUS
			)
	private Player leftassociation;
	
//Association a MATCH
	@OneToOne(targetEntity=Match.class,mappedBy=MatchContract.ASSOCIATION_PLAYERSTATUS)
	private Match rightassociation;
	
	
//Constructor
	public PlayerStatus() {
		super();
	}
	public PlayerStatus(Player leftassociation, Match rightassociation, Integer status, Float statustime) {
		super();
		this.leftassociation = leftassociation;
		this.rightassociation = rightassociation;
		this.status = status;
		this.statustime = statustime;
	}

	
//Player
	public Player getLeftAssociation() {
		return leftassociation;
	}
	public void setLeftAssociation(Player leftassociation) {
		this.leftassociation = leftassociation;
	}
	
//Match
	public Match getRightAssociation() {
		return rightassociation;
	}
	public void setRightAssociation(Match rightassociation) {
		this.rightassociation = rightassociation;
	}

//Status
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

//StatusTime
	public Float getStatusTime() {
		return statustime;
	}
	public void setStatusTime(Float statustime) {
		this.statustime = statustime;
	}
	
}
