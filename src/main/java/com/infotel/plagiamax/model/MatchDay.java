package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infotel.plagiamax.model.base.DBItem;

@Entity
@Table(name = "matchday")
public class MatchDay extends DBItem {
	
	private String label;
	
	//Association to Season
		@ManyToOne(targetEntity = Player.class)
		@JsonManagedReference
		private Player player;

	//Association to MATCH
		@ManyToOne(targetEntity = Match.class)
		@JsonManagedReference
		private Match match;

}
