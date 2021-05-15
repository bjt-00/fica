package com.fica.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fica.service.Universes;

@RestController
@RequestMapping("/universes")
public class UniversesController {

	@Autowired 
	Universes universesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUniverses() {
		return universesService.getUniverses();
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public String getUniverseById(@PathVariable("id")String id) {
		return universesService.getUniverseById(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	public String addUniverse() {
		universesService.addUniverse();
		return "addFictionalCharacters ";
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public String updateUniverse(@PathVariable("id")String id) {
		universesService.updateUniverse();
		return "updating "+id;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public String deleteUniverse(@PathVariable("id")String id) {
		universesService.deleteUniverse();
		return "deleting "+id;
	}
}
