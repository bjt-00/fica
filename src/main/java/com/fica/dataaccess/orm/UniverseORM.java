package com.fica.dataaccess.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name="universe")
public class UniverseORM {

	private Long universeId;
	private String universeName;
	private List<FictionalCharacterORM> fictionalCharacters;
	
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

	@OneToMany(fetch=FetchType.EAGER, mappedBy="universeId")
	public List<FictionalCharacterORM> getFictionalCharacters() {
		return fictionalCharacters;
	}

	public void setFictionalCharacters(List<FictionalCharacterORM> fictionalCharacters) {
		this.fictionalCharacters = fictionalCharacters;
	}
}
