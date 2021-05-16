package com.fica.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.fica.dataaccess.dao.FictionalCharactersDAO;
import com.fica.dataaccess.orm.FictionalCharacterORM;

@Transactional
@Service
public class FictionalCharactersService implements FictionalCharacters {

	@Resource
	FictionalCharactersDAO dao;
	
	@Override
	public List<FictionalCharacterORM> getList() {
		return dao.getList();
	}

	@Override
	public FictionalCharacterORM getFictionalCharacterById(Long universeId) {
		return dao.getFictionalCharacterById(universeId);
	}

	@Override
	public FictionalCharacterORM save(FictionalCharacterORM fictionalCharacterORM) {
		//we can mature business logic here to make sure object save successfully.
		 return dao.save(fictionalCharacterORM);
	}

	@Override
	public boolean update(FictionalCharacterORM fictionalCharacterORM) {
		try {
			dao.update(fictionalCharacterORM.getFictionalCharacterId(),fictionalCharacterORM.getFullName());
			return true;
		}catch(Exception e) {
			e.printStackTrace();//we can use logger here, due to time constraints ignoring that part
		}
		return false;
	}

	@Override
	public boolean delete(Long fictionalCharacterId) {
		try {
			dao.deleteById(fictionalCharacterId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();//we can use logger here, due to time constraints ignoring that part
		}
		return false;
	}

}
