package com.nirav.rest.rest_experiment.resource;

import com.nirav.rest.rest_experiment.model.Profile;
import com.nirav.rest.rest_experiment.service.ProfileService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
public class ProfileResource
{
    ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfiles()
    {
        return profileService.getAllProfiles();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile)
    {
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile)
    {
        Profile profile1 = profileService.getProfile(profileName);
        if(profile1 == null)
            return null;

        profile.setProfileName(
                profileName);//Even if user sends incorrect/intentionally wrong profileName in profile body input, we will ignore it and override it with path param value.
        profile.setId(profile1.getId());
        return profileService.updateProfile(profile);
    }

    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("profileName") String profileName)
    {
        return profileService.getProfile(profileName);
    }

    @DELETE
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile removeProfile(@PathParam("profileName") String profileName)
    {
        return profileService.removeProfile(profileName);
    }
}
