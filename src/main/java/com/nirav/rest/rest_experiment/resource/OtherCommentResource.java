package com.nirav.rest.rest_experiment.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages/{messageId}/other-comments")
public class OtherCommentResource
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getComments(@PathParam("messageId") int messageId)
    {
        return String.valueOf(messageId);
    }

    @GET
    @Path("/{commentId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId)
    {
        return String.valueOf(messageId) + " " + String.valueOf(commentId);
    }

}
