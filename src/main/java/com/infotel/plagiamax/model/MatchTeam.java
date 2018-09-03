package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matchteam")
public class MatchTeam {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmatchteam", unique = true, nullable = false)
	private Long idmatchteam;
//	private Long idteam;
//	private Long idmatch;
	private Boolean ishometeam;
	
	public MatchTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatchTeam(Long idmatchteam, 
//			Long idteam, Long idmatch, 
			Boolean ishometeam) {
		super();
		this.idmatchteam = idmatchteam;
//		this.idteam = idteam;
//		this.idmatch = idmatch;
		this.ishometeam = ishometeam;
	}
	
	public Long getIdmatchteam() {
		return idmatchteam;
	}
	public void setIdmatchteam(Long idmatchteam) {
		this.idmatchteam = idmatchteam;
	}
	
//	public Long getIdteam() {
//		return idteam;
//	}
//	public void setIdteam(Long idteam) {
//		this.idteam = idteam;
//	}
//	
//	public Long getIdmatch() {
//		return idmatch;
//	}
//	public void setIdmatch(Long idmatch) {
//		this.idmatch = idmatch;
//	}
	
	public Boolean getIshometeam() {
		return ishometeam;
	}
	public void setIshometeam(Boolean ishometeam) {
		this.ishometeam = ishometeam;
	}
	
}
