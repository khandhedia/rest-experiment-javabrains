package com.nirav.rest.rest_experiment.exceptions;

import com.nirav.rest.rest_experiment.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
    @Override
    public Response toResponse(Throwable e)
    {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), "500", "blank documentation");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }
}
