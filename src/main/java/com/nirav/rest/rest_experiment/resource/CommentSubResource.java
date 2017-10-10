package com.nirav.rest.rest_experiment.resource;

import com.nirav.rest.rest_experiment.model.Comment;
import com.nirav.rest.rest_experiment.service.CommentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentSubResource
{
    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("id") int id)
    {
        return commentService.getAllComments(id);
    }

    @POST
    public Comment addComment(@PathParam("id") int id, Comment comment)
    {
        return commentService.addComment(id, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("id") int id, @PathParam("commentId") int commentId, Comment comment)
    {
        comment.setId(commentId);
        return commentService.updateComment(commentId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteComment(@PathParam("id") int id, @PathParam("commentId") long commentId)
    {
        commentService.removeComment(id, commentId);
    }


/*    @GET
    @Path("/{commentId}")
    public Comment getMessage(@PathParam("id") int id, @PathParam("commentId") long commentId) {
        return commentService.getComment(id, commentId);
    }*/
}
