package com.fica.service;

import java.util.List;

import com.fica.dataaccess.orm.FictionalCharacterORM;

public interface FictionalCharacters {

	List<FictionalCharacterORM> getList();

	FictionalCharacterORM getFictionalCharacterById(Long universeId);

	FictionalCharacterORM save(FictionalCharacterORM fictionalCharacterORM);

	boolean update(FictionalCharacterORM fictionalCharacterORM);

	boolean delete(Long fictionalCharacterId);

}
