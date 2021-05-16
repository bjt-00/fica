package com.fica.dataaccess.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name="fictional_character")
public class FictionalCharacterORM {

	private Long fictionalCharacterId;
	private String fullName;
	
	@JsonCreator
	public FictionalCharacterORM() {
		
	}
	@Id
	@GeneratedValue
	public Long getFictionalCharacterId() {
		return fictionalCharacterId;
	}
	public void setFictionalCharacterId(Long fictionalCharacterId) {
		this.fictionalCharacterId = fictionalCharacterId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
