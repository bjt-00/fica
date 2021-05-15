package com.fica.service;

public interface FictionalCharacters {

	String getFictionalCharacters();

	String getFictionalCharacterById(String id);

	boolean addFictionalCharacter();

	boolean updateFictionalCharacter();

	boolean deleteFictionalCharacter();

}
