package com.nirav.rest.rest_experiment.resource;

import com.nirav.rest.rest_experiment.exceptions.DataNotFoundException;
import com.nirav.rest.rest_experiment.model.Message;
import com.nirav.rest.rest_experiment.service.MessageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/messages")
public class MessageResource
{
    MessageService messageService = new MessageService();

/*

    Plain GET method without query params..

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages()
    {
        return messageService.getAllMessages();
    }
*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size, @Context UriInfo uriInfo)
    {
        if(year > 0)
        {
            return messageService.getAllMessagesForYear(year);
        }

        if(start > 0 && size > 0)
        {
            return messageService.getAllMessagesPaginated(start, size);
        }

        List<Message> allMessages = messageService.getAllMessages();
        for (Message message : allMessages)
        {
            message.addLink(uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getMessage").resolveTemplate("id", message.getId()).build().toString(), "self");
        }

        return allMessages;

    }

/*


    //Way to access using Bean Param - Just crate a Bean with all query params as private member variable and use BeanParam annotation!

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessagesUsingBean(@BeanParam MessageFilterBean messageFilterBean)
    {

        System.out.println("Using Bean Param!!");
        int size = messageFilterBean.getSize();
        int start = messageFilterBean.getStart();
        int year = messageFilterBean.getYear();

        if(year > 0)
        {
            return messageService.getAllMessagesForYear(year);
        }

        if(start > 0 && size > 0)
        {
            return messageService.getAllMessagesPaginated(start, size);
        }

        return messageService.getAllMessages();
    }
*/

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException
    {
        Message newMessage = messageService.addMessage(message);
        //return Response.status(Response.Status.CREATED).entity(newMessage).build();
        //return Response.created(new URI("/webapi/messages/2" + newMessage.getId())).entity(newMessage).build();
        //return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build()).entity(newMessage).build();
        return Response.created(uriInfo.getRequestUriBuilder().path(String.valueOf(newMessage.getId())).build()).entity(newMessage).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("id") int id, Message message)
    {
        message.setId(id);//Even if user sends incorrect/intentionally wrong id in message body input, we will ignore it and override it with path param value.
        return messageService.updateMessage(message);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("id") int id , @Context UriInfo uriInfo)
    {
        Message message = messageService.getMessage(id);
        if(message == null)
            throw new DataNotFoundException("Message not found");

        message.addLink(uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getMessage").resolveTemplate("id", id).build().toString(), "self");
        return message;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message removeMessage(@PathParam("id") int id)
    {
        return messageService.removeMessage(id);
    }


    @Path("/{id}/comments/")
    @Produces(MediaType.APPLICATION_JSON)
    public CommentSubResource getCommentSubResource()
    {
        return new CommentSubResource();
    }
}
