package com.shariqparwez.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.shariqparwez.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}
	
	public Activity get(String id) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		//Activity response = target.path("activities/" + id).request().get(Activity.class);
		Activity response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
		
		System.out.println(response);
		
		return response;
	
	}

}
