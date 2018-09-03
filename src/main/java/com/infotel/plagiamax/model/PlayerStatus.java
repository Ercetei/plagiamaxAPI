package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "playerstatus")
public class PlayerStatus {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idplayerstatus", unique = true, nullable = false)
	private Long idplayerstatus;
//	private Long idplayer;
//	private Long idmatch;
	private Integer status;
	private Float statusTime;
	
	public PlayerStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerStatus(Long idplayerstatus, 
//			Long idplayer, Long idmatch, 
			Integer status, Float statusTime) {
		super();
		this.idplayerstatus = idplayerstatus;
//		this.idplayer = idplayer;
//		this.idmatch = idmatch;
		this.status = status;
		this.statusTime = statusTime;
	}

	public Long getIdplayerstatus() {
		return idplayerstatus;
	}
	public void setIdplayerstatus(Long idplayerstatus) {
		this.idplayerstatus = idplayerstatus;
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

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Float getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(Float statusTime) {
		this.statusTime = statusTime;
	}
	
}
