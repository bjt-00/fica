package com.fica.dataaccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fica.dataaccess.orm.UniverseORM;

@Repository
public interface UniversesDAO extends JpaRepository<UniverseORM,Long> {
	
	@Query("select distinct u from UniverseORM u")
	List<UniverseORM> getList();
	
	@Query("select u from UniverseORM u where u.universeId= :universeId")
	UniverseORM getUniverseById(@Param("universeId")Long universeId);

	@Modifying
	@Query("update UniverseORM f set f.universeName= :universeName where f.universeId= :universeId")
	void update(Long universeId,String universeName);

}
