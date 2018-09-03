package com.infotel.plagiamax.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "match")
public class Match {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmatch", unique = true, nullable = false)
	private Long idmatch;
	private String label;
	private Integer status;
//	private Long idplace;
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(Long idmatch, String label, Integer status
//			, Long idplace
			) {
		super();
		this.idmatch = idmatch;
		this.label = label;
		this.status = status;
//		this.idplace = idplace;
	}

	public Long getIdmatch() {
		return idmatch;
	}
	public void setIdmatch(Long idmatch) {
		this.idmatch = idmatch;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

//	public Long getIdplace() {
//		return idplace;
//	}
//	public void setIdplace(Long idplace) {
//		this.idplace = idplace;
//	}
	
}
