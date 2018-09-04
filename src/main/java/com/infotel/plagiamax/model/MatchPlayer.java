package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer extends DBItem {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Float enteringtime;
	private Float exittime;
	
//Association to PLAYER
	@OneToOne(targetEntity=Player.class,mappedBy=PlayerContract.ASSOCIATION_MATCHPLAYER)
	private Player leftassociation;
	
//Association to MATCH
	@OneToOne(targetEntity=Match.class,mappedBy=MatchContract.ASSOCIATION_MATCHPLAYER)
	private Match rightassociation;
	
	
//Constructor	
	public MatchPlayer() {
		super();
	}
	public MatchPlayer(Player leftassociation, Match rightassociation, Float enteringtime, Float exittime) {
		super();
		this.leftassociation = leftassociation;
		this.rightassociation = rightassociation;
		this.enteringtime = enteringtime;
		this.exittime = exittime;
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
	
//EnteringTime
	public Float getEnteringtime() {
		return enteringtime;
	}
	public void setEnteringtime(Float enteringtime) {
		this.enteringtime = enteringtime;
	}
	
//ExitTime
	public Float getExittime() {
		return exittime;
	}
	public void setExittime(Float exittime) {
		this.exittime = exittime;
	}
	
}
