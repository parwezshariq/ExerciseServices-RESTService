package com.shariqparwez;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.shariqparwez.model.Activity;
import com.shariqparwez.repository.ActivityRepositoryStub;
import com.shariqparwez.repository.ActivityRespository;

@Path("search/activities")
public class ActivitySearchResource {

	private ActivityRespository activityRepository = new ActivityRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, javax.ws.rs.core.MediaType.APPLICATION_XML})
	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions,
			@QueryParam(value = "durationFrom") int durationFrom,
			@QueryParam(value = "durationTo") int durationTo) {
		System.out.println(descriptions + ", " + durationFrom + ", " + durationTo);
		
		List<Activity> activities = activityRepository.findByDescription(descriptions, durationFrom, durationTo);
	
		if(activities == null || activities.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
	
	}
	
}
