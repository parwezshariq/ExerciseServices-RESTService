package com.shariqparwez;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shariqparwez.model.Activity;
import com.shariqparwez.repository.ActivityRepositoryStub;
import com.shariqparwez.repository.ActivityRespository;

@Path("activities")
public class ActivityResource {
	
	private ActivityRespository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	//@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}")
	public Activity getActivity(@PathParam ("activityId") String activityId){
		return activityRepository.findActivity(activityId);
	}
	
}
 