package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infotel.plagiamax.contract.MatchContract;
import com.infotel.plagiamax.contract.PlayerContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer extends DBItem {

	private Float enteringtime;
	private Float exittime;

	@ManyToOne
	@JsonIgnoreProperties({ PlayerContract.ASSOCIATION_MATCHPLAYER, PlayerContract.ASSOCIATION_PERIODS,
			PlayerContract.ASSOCIATION_PLACE, PlayerContract.ASSOCIATION_PLAYERBETS,
			PlayerContract.ASSOCIATION_PLAYERSTATUS, PlayerContract.ASSOCIATION_STATS })
	private Player player;

	@ManyToOne
	@JsonIgnoreProperties({ MatchContract.ASSOCIATION_EVENT, MatchContract.ASSOCIATION_MATCHBET,
			MatchContract.ASSOCIATION_MATCHDAY, MatchContract.ASSOCIATION_MATCHPLAYER,
			MatchContract.ASSOCIATION_MATCHTEAM, MatchContract.ASSOCIATION_PLACE })
	private Match match;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Float getEnteringtime() {
		return enteringtime;
	}

	public void setEnteringtime(Float enteringtime) {
		this.enteringtime = enteringtime;
	}

	public Float getExittime() {
		return exittime;
	}

	public void setExittime(Float exittime) {
		this.exittime = exittime;
	}

	public MatchPlayer() {
		super();
	}
}
