package com.fica.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fica.service.FictionalCharacters;

@RestController
@RequestMapping("/fictional-characters")
public class FictionalCharactersController {

	@Autowired 
	FictionalCharacters fictionalCharactersService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getFictionalCharacters() {
		return fictionalCharactersService.getFictionalCharacters();
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public String getFictionalCharacterById(@PathVariable("id")String id) {
		return fictionalCharactersService.getFictionalCharacterById(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addFictionalCharacter() {
		fictionalCharactersService.addFictionalCharacter();
		return "addFictionalCharacters ";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public String updateFictionalCharacter(@PathVariable("id")String id) {
		fictionalCharactersService.updateFictionalCharacter();
		return "updating "+id;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public String deleteFictionalCharacter(@PathVariable("id")String id) {
		fictionalCharactersService.deleteFictionalCharacter();
		return "deleting "+id;
	}
}
