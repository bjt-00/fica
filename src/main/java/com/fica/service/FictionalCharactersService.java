package com.fica.service;

import org.springframework.stereotype.Service;

@Service
public class FictionalCharactersService implements FictionalCharacters {

	@Override
	public String getFictionalCharacters() {
		return "str1,str2,Str3,...";
	}

	@Override
	public String getFictionalCharacterById(String id) {
		return "getUniverseById "+id;
	}

	@Override
	public boolean addFictionalCharacter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFictionalCharacter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFictionalCharacter() {
		// TODO Auto-generated method stub
		return false;
	}

}
