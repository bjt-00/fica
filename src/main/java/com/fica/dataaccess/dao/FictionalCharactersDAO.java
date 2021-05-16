package com.fica.dataaccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fica.dataaccess.orm.FictionalCharacterORM;

@Repository
public interface FictionalCharactersDAO extends JpaRepository<FictionalCharacterORM,Long> {
	@Query("select distinct f from FictionalCharacterORM f")
	List<FictionalCharacterORM> getList();
	
	@Query("select f from FictionalCharacterORM f where f.fictionalCharacterId= :fictionalCharacterId")
	FictionalCharacterORM getFictionalCharacterById(@Param("fictionalCharacterId")Long fictionalCharacterId);

	@Modifying
	@Query("update FictionalCharacterORM f set f.fullName= :fullName where f.fictionalCharacterId= :fictionalCharacterId")
	void update(Long fictionalCharacterId,String fullName);
}
