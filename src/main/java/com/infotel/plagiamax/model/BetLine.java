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

@Entity
@Table(name = "betline")
public class BetLine {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@OneToOne(targetEntity=Bet.class,mappedBy=BetContract.BetLineAssociation)
	private Bet leftAssociation;
	
	@OneToOne(targetEntity=BetType.class,mappedBy=BetTypeContract.BetLineAssociation)
	private BetType rightAssociation;
	
	
	

}
