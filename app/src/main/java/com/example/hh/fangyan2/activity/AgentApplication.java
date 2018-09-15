package com.example.hh.fangyan2.activity;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;


public class AgentApplication extends Application {

    private List<Activity> activities = new ArrayList<>();

    private static AgentApplication instance = null;

    private AgentApplication() {

    }

    public synchronized static AgentApplication getInstance() {
        if (instance == null) {
            instance = new AgentApplication();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

    public void finishAllActivities(Activity activity) {
        for (Activity activity1 : activities) {
            if (activity1 != activity) {
                activity1.finish();
            }
        }
        activity.finish();
        System.exit(0);
    }

}
