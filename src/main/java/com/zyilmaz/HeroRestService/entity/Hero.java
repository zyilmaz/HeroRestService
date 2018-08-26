package com.zyilmaz.HeroRestService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
public class Hero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;
	
	public Hero() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}
	
	public Hero(String name) {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("id : " + id + "\n");
		buf.append("name : " + name + "\n");
		return buf.toString();
	}
	
	
	
}
