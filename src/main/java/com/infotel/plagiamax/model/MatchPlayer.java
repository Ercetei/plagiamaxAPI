package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer extends DBItem {

	private Float enteringtime;
	private Float exittime;

//Association to PLAYER
	@OneToOne(targetEntity = Player.class, mappedBy = PlayerContract.ASSOCIATION_MATCHPLAYER)
	private Player player;

//Association to MATCH
	@OneToOne(targetEntity = Match.class, mappedBy = MatchContract.ASSOCIATION_MATCHPLAYER)
	private Match match;

//Constructor	
	public MatchPlayer() {
		super();
	}

	public MatchPlayer(Long id, Player player, Match match, Float enteringtime, Float exittime) {
		super();
		this.id = id;
		this.player = player;
		this.match = match;
		this.enteringtime = enteringtime;
		this.exittime = exittime;
	}

//Player
	public Player getLeftAssociation() {
		return player;
	}

	public void setLeftAssociation(Player player) {
		this.player = player;
	}

//Match
	public Match getRightAssociation() {
		return match;
	}

	public void setRightAssociation(Match match) {
		this.match = match;
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
