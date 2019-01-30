package com.shariqparwez.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shariqparwez.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.get("1234");
		System.out.println(activity);
		
		assertNotNull(activity);
	}

}
