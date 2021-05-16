package com.fica.service;

import java.util.List;

import com.fica.dataaccess.orm.UniverseORM;

public interface Universes {

	List<UniverseORM> getList();

	UniverseORM getUniverseById(Long universeId);

	boolean update(UniverseORM universeORM);

	UniverseORM save(UniverseORM universeORM);

	boolean delete(Long universeId);

}
