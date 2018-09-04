package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "bettype")
public abstract class BetType extends DBItem {

	protected Float initialodds;
	protected Float currentodds;
	protected Integer status;
	
	@OneToOne(targetEntity=BetLine.class)
	private BetLine BetLineAssociation;
	
	@ManyToMany(targetEntity=MatchBet.class)
	private List<MatchBet> matchbet;
	
	@ManyToMany(targetEntity=TeamBet.class)
	private List<MatchBet> teambet;
	
	@ManyToMany(targetEntity=Player.class)
	private List<MatchBet> playerbet;
	
	public BetType() {
		super();
	}

	public BetLine getBetLineAssociation() {
		return BetLineAssociation;
	}

	public void setBetLineAssociation(BetLine betLineAssociation) {
		BetLineAssociation = betLineAssociation;
	}

	public Float getInitialodds() {
		return initialodds;
	}

	public void setInitialodds(Float initialodds) {
		this.initialodds = initialodds;
	}

	public Float getCurrentodds() {
		return currentodds;
	}

	public void setCurrentodds(Float currentodds) {
		this.currentodds = currentodds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<MatchBet> getMatchbet() {
		return matchbet;
	}

	public void setMatchbet(List<MatchBet> matchbet) {
		this.matchbet = matchbet;
	}

	public List<MatchBet> getTeambet() {
		return teambet;
	}

	public void setTeambet(List<MatchBet> teambet) {
		this.teambet = teambet;
	}

	public List<MatchBet> getPlayerbet() {
		return playerbet;
	}

	public void setPlayerbet(List<MatchBet> playerbet) {
		this.playerbet = playerbet;
	}

	public BetType(Long id, Float initialodds, Float currentodds, Integer status, BetLine betLineAssociation,
			List<MatchBet> matchbet, List<MatchBet> teambet, List<MatchBet> playerbet) {
		super();
		this.id = id;
		this.initialodds = initialodds;
		this.currentodds = currentodds;
		this.status = status;
		BetLineAssociation = betLineAssociation;
		this.matchbet = matchbet;
		this.teambet = teambet;
		this.playerbet = playerbet;
	}
	

}
