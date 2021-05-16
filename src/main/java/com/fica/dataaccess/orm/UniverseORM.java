package com.fica.dataaccess.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name="universe")
public class UniverseORM {

	private Long universeId;
	private String universeName;
	
	@JsonCreator
	public UniverseORM() {}
	
	@Id
	@GeneratedValue
	public Long getUniverseId() {
		return universeId;
	}
	public void setUniverseId(Long universeId) {
		this.universeId = universeId;
	}
	public String getUniverseName() {
		return universeName;
	}
	public void setUniverseName(String universeName) {
		this.universeName = universeName;
	}
}
