package com.fica.service;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.fica.dataaccess.dao.UniversesDAO;
import com.fica.dataaccess.orm.UniverseORM;

@Transactional
@Service
public class UniversesService implements Universes {

	@Resource
	UniversesDAO dao;
	
	@Override
	public List<UniverseORM> getList() {
		return dao.getList();
	}

	@Override
	public UniverseORM getUniverseById(Long universeId) {
		return dao.getUniverseById(universeId);
	}

	@Override
	public UniverseORM save(UniverseORM universeORM) {
		//we can mature business logic here to make sure object save successfully.
		 return dao.save(universeORM);
	}

	@Override
	public boolean update(UniverseORM universeORM) {
		try {
			dao.update(universeORM.getUniverseId(),universeORM.getUniverseName());
			return true;
		}catch(Exception e) {
			e.printStackTrace();//we can use logger here, due to time constraints ignoring that part
		}
		return false;
	}

	@Override
	public boolean delete(Long universeId) {
		try {
			dao.deleteById(universeId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();//we can use logger here, due to time constraints ignoring that part
		}
		return false;
	}

}
