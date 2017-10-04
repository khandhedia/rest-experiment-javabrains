package com.nirav.rest.rest_experiment;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hi")
public class MessageResource
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHi()
    {
        return "Hi";
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public String sayHiPost()
    {
        return "Hi";
    }



}
