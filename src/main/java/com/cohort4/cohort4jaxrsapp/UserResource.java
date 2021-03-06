package com.cohort4.cohort4jaxrsapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cohort4.cohort4jaxrsapp.dao.UserDao;
import com.cohort4.cohort4jaxrsapp.model.User;
import com.google.gson.Gson;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {
	
	private Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItems() {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getAll();
		
		String jsonString = gson.toJson(userList);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnItem(@PathParam("id") int id) {
		UserDao userDao = new UserDao();
		User user = userDao.getAUser(id);
		if(user != null) {
			String jsonString = gson.toJson(user);
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		} else {
			Map<String, String> errorMsg = new HashMap<>();
			errorMsg.put("ERROR", "Inavlid user id");
			
			String errorString = gson.toJson(errorMsg);
			return Response
					.status(400)
					.entity(errorString)
					.build();
		}
	}
	
	//:TODO from here
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addItem() {
		return "Add user to system";
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem() {
		return "Update a user";
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem() {
		return "Delete a user";
	}
	
	//LOG4J 
	//LOGBACK
	//SLF4J 

}
