package com.nirav.rest.rest_experiment.database;

import com.nirav.rest.rest_experiment.model.Message;
import com.nirav.rest.rest_experiment.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass
{

    private static Map<Integer, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Integer, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
