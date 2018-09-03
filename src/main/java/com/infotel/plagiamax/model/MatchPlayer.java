package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmatchplayer", unique = true, nullable = false)
	private Long idmatchplayer;
//	private Long idplayer;
//	private Long idmatch;
	private Float enteringtime;
	private Float exittime;
	
	public MatchPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatchPlayer(Long idmatchplayer, 
//			Long idplayer, Long idmatch, 
			Float enteringtime, Float exittime) {
		super();
		this.idmatchplayer = idmatchplayer;
//		this.idplayer = idplayer;
//		this.idmatch = idmatch;
		this.enteringtime = enteringtime;
		this.exittime = exittime;
	}
	
	public Long getIdmatchplayer() {
		return idmatchplayer;
	}
	public void setIdmatchplayer(Long idmatchplayer) {
		this.idmatchplayer = idmatchplayer;
	}
	
//	public Long getIdplayer() {
//		return idplayer;
//	}
//	public void setIdplayer(Long idplayer) {
//		this.idplayer = idplayer;
//	}
//	
//	public Long getIdmatch() {
//		return idmatch;
//	}
//	public void setIdmatch(Long idmatch) {
//		this.idmatch = idmatch;
//	}
	
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
	
}
