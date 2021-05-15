package com.fica.service;

import org.springframework.stereotype.Service;

@Service
public class UniversesService implements Universes {

	@Override
	public String getUniverses() {
		return "str1,str2,str3,...";
	}

	@Override
	public String getUniverseById(String id) {
		return "getUniverseById "+id;
	}

	@Override
	public boolean addUniverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUniverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUniverse() {
		// TODO Auto-generated method stub
		return false;
	}

}
