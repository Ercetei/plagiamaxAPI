package com.infotel.plagiamax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.BetTypeContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "betline")
public class BetLine extends DBItem {

	private Long momentodds;

	@ManyToOne(targetEntity = Bet.class)
	private Bet bet;

	@OneToMany(targetEntity = BetType.class, mappedBy = BetTypeContract.ASSOCIATION_TABLE_BETLINE)
	private List<BetType> bettypes;

	public BetLine() {
		super();
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public List<BetType> getBetTypes() {
		return bettypes;
	}

	public void setBetType(List<BetType> bettypes) {
		this.bettypes = bettypes;
	}

	public Long getMomentodds() {
		return momentodds;
	}

	public void setMomentodds(Long momentodds) {
		this.momentodds = momentodds;
	}

	public BetLine(Long id, Long momentodds, Bet bet, List<BetType> bettypes) {
		super();
		this.id = id;
		this.momentodds = momentodds;
		this.bet = bet;
		this.bettypes = bettypes;
	}

}
