package com.shariqparwez.repository;

import java.util.List;

import com.shariqparwez.model.Activity;

public interface ActivityRespository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

}