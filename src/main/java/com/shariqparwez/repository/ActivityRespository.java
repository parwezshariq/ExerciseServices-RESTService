package com.shariqparwez.repository;

import java.util.List;

import com.shariqparwez.model.Activity;
import com.shariqparwez.model.ActivitySearch;

public interface ActivityRespository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);

}