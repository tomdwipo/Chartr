package com.androbos.chartr;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by tommy on 24/08/15.
 */
public class ParseAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "MrHkdJiEcUHQpKZ8nguq9YqSr7k5VWUFlXNTJ1rl", "r0YBIu2812EnHkmOQOlwzOkZc91PbyMmwGaulY3n");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
    }
}