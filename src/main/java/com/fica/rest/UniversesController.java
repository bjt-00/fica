package com.fica.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/universes")
public class UniversesController {

	@RequestMapping(method=RequestMethod.GET)
	public String getUniverses() {
		return "str1,str2,...";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public String getUniverseById(@PathVariable("id")String id) {
		return "str "+id;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addUniverse() {
		return "addFictionalCharacters ";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public String updateUniverse(@PathVariable("id")String id) {
		return "updating "+id;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public String deleteUniverse(@PathVariable("id")String id) {
		return "deleting "+id;
	}
}
