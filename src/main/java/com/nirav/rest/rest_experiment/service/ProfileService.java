package com.nirav.rest.rest_experiment.service;

import com.nirav.rest.rest_experiment.model.Profile;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.nirav.rest.rest_experiment.database.DatabaseClass.getProfiles;

public class ProfileService
{
    private static Map<String, Profile> profiles = getProfiles();

    {
        Profile p1 = new Profile(1, "nirav-profile", "Nirav", "Khandhedia" );
        Profile p2 = new Profile(2, "mittal-profile", "Mittal", "Khandhedia" );
        Profile p3 = new Profile(3, "mitul-profile", "Mitul", "Khandhedia" );

        profiles.put(p1.getProfileName(), p1);
        profiles.put(p2.getProfileName(), p2);
        profiles.put(p3.getProfileName(), p3);
    }

    public List<Profile> getAllProfiles()
    {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName)
    {
        return profiles.get(profileName);
    }


    public Profile removeProfile(String profileName)
    {
        return profiles.remove(profileName);
    }

    public Profile addProfile(Profile profile)
    {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile)
    {
        if(StringUtils.isEmpty(profile.getProfileName()))
            return null;
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
}
