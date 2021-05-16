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
import com.fica.dataaccess.orm.UniverseORM;
import com.fica.service.Universes;

@RestController
@RequestMapping("/universes")
public class UniversesController {

	@Autowired 
	Universes universesService;
	
	//Notes: we can alter response based on our need, paylod or tracking info
	//could also be attached and we can also play with status codes. due to time constraints
	//i am ignoring that part. and going with simple route.
	@RequestMapping(method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UniverseORM> getFictionalCharacters() {
		return universesService.getList();
	}

	//Notes: we can alter response based on our need, paylod or tracking info
	//could also be attached and we can also play with status codes. due to time constraints
	//i am ignoring that part. and going with simple route.
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public UniverseORM getFictionalCharacterById(@PathVariable("id")Long id) {
		return universesService.getUniverseById(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	public UniverseORM addFictionalCharacter(@RequestBody UniverseORM universeORM) {
		universeORM = universesService.save(universeORM);
		return universeORM;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.PUT)
	public UniverseORM updateFictionalCharacter(@PathVariable("id")Long id,@RequestBody UniverseORM universeORM) {
		
		//its part of requirement, otherwise we don't need explicit id here
		universeORM.setUniverseId(id);
		
		universesService.update(universeORM);
		return universeORM;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deleteFictionalCharacter(@PathVariable("id")Long id) {
		
		Response response = new Response();
		if(universesService.delete(id)) {
			response.setStatusCode(200);
			response.setMessage("Given Universe id:"+id+" is deleted successfully.");//we can define this in properties file
		}else {
			response.setStatusCode(403);
			response.setMessage("Given Universe id:"+id+" deletion failed.");
		}
		
		return response;
	}
}
