package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infotel.plagiamax.contract.BetContract;
import com.infotel.plagiamax.contract.BetTypeContract;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "betline")
public class BetLine extends DBItem {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private Long momentodds;
	

	@OneToOne(targetEntity=Bet.class,mappedBy=BetContract.ASSOCIATION_TABLE_BETLINE)
	private Bet leftAssociation;
	
	@OneToOne(targetEntity=BetType.class,mappedBy=BetTypeContract.ASSOCIATION_TABLE_BETLINE)
	private BetType rightAssociation;
	
	public BetLine() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bet getLeftAssociation() {
		return leftAssociation;
	}

	public void setLeftAssociation(Bet leftAssociation) {
		this.leftAssociation = leftAssociation;
	}

	public BetType getRightAssociation() {
		return rightAssociation;
	}

	public void setRightAssociation(BetType rightAssociation) {
		this.rightAssociation = rightAssociation;
	}

	public Long getMomentodds() {
		return momentodds;
	}

	public void setMomentodds(Long momentodds) {
		this.momentodds = momentodds;
	}
	
	public BetLine(Long id, Long momentodds, Bet leftAssociation, BetType rightAssociation) {
		super();
		this.id = id;
		this.momentodds = momentodds;
		this.leftAssociation = leftAssociation;
		this.rightAssociation = rightAssociation;
	}
	
	
	

}
