package com.fica.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fictional-characters")
public class FictionalCharactersController {

	@RequestMapping(method=RequestMethod.GET)
	public String getFictionalCharacters() {
		return "str1,str2,...";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public String getFictionalCharacterById(@PathVariable("id")String id) {
		return "str "+id;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addFictionalCharacter() {
		return "addFictionalCharacters ";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public String updateFictionalCharacter(@PathVariable("id")String id) {
		return "updating "+id;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public String deleteFictionalCharacter(@PathVariable("id")String id) {
		return "deleting "+id;
	}
}
