package com.infotel.plagiamax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;


@Entity
@Table(name="worftenflur")
public class MyModel {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	private String one;
	private Integer two;
	private Boolean three;
	private String[] four;

	public MyModel() {}
	
	public MyModel(String one, Integer two, Boolean three, String[] four) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
	}
	
//	public MyModel(Long key, String one, Integer two, Boolean three, String[] four) {
//		super();
//		this.key = key;
//		this.one = one;
//		this.two = two;
//		this.three = three;
//		this.four = four;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public Integer getTwo() {
		return two;
	}

	public void setTwo(Integer two) {
		this.two = two;
	}

	public Boolean getThree() {
		return three;
	}

	public void setThree(Boolean three) {
		this.three = three;
	}

	public String[] getFour() {
		return four;
	}

	public void setFour(String[] four) {
		this.four = four;
	}

	
}
