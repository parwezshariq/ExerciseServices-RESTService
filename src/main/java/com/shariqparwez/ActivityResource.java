package com.shariqparwez;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.shariqparwez.model.Activity;
import com.shariqparwez.model.User;
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
		System.out.println("Getting activity ID: " + activityId);
		
		return activityRepository.findActivity(activityId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user")
	public User getActivityUser(@PathParam ("activityId") String activityId){
		return activityRepository.findActivity(activityId).getUser();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("activity")
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepository.create(activity);
		
		return activity;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("activity")
	public Activity createActivity(Activity activity) {
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		
		activityRepository.create(activity);
		
		return activity;
	}
	
}
 