package com.fica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fica.common.model.response.Response;
import com.fica.dataaccess.orm.FictionalCharacterORM;
import com.fica.service.FictionalCharacters;

@RestController
@RequestMapping("/fictional-characters")
public class FictionalCharactersController {

	@Autowired 
	FictionalCharacters fictionalCharactersService;
	
	//Notes: we can alter response based on our need, paylod or tracking info
	//could also be attached and we can also play with status codes. due to time constraints
	//i am ignoring that part. and going with simple route.
	@RequestMapping(method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FictionalCharacterORM> getFictionalCharacters() {
		return fictionalCharactersService.getList();
	}

	//Notes: we can alter response based on our need, paylod or tracking info
	//could also be attached and we can also play with status codes. due to time constraints
	//i am ignoring that part. and going with simple route.
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public FictionalCharacterORM getFictionalCharacterById(@PathVariable("id")Long id) {
		return fictionalCharactersService.getFictionalCharacterById(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	public FictionalCharacterORM addFictionalCharacter(@RequestBody FictionalCharacterORM fictionalCharacterORM) {
		fictionalCharacterORM = fictionalCharactersService.save(fictionalCharacterORM);
		return fictionalCharacterORM;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public FictionalCharacterORM updateFictionalCharacter(@PathVariable("id")Long id,@RequestBody FictionalCharacterORM fictionalCharacterORM) {
		
		//its part of requirement, otherwise we don't need explicit id here
		fictionalCharacterORM.setFictionalCharacterId(id);
		
		fictionalCharactersService.update(fictionalCharacterORM);
		return fictionalCharacterORM;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deleteFictionalCharacter(@PathVariable("id")Long id) {
		
		Response response = new Response();
		if(fictionalCharactersService.delete(id)) {
			response.setStatusCode(200);
			response.setMessage("Given Fiction Character id:"+id+" is deleted successfully.");//we can define this in properties file
		}else {
			response.setStatusCode(403);
			response.setMessage("Given Fiction Character id:"+id+" deletion failed.");
		}
		
		return response;
	}
}
