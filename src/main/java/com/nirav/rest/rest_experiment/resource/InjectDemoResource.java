package com.nirav.rest.rest_experiment.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource
{

    @GET
    @Path("matrix-param")
    public String matrixParamAnnotation(@MatrixParam("matrix") String matrix)
    {
        return "Matrix Param value is " + matrix;
    }


    @GET
    @Path("matrix-complex-param/matrix-sub-param")
    public String matrixComplexParamAnnotation(@MatrixParam("one") String one, @MatrixParam("two") String two)
    {
        return "Matrix Param values are " + one + " and " + two;
    }

    @GET
    @Path("header-param")
    public String headerParamAnnotation(@HeaderParam("header") String header)
    {
        return "Header Param value is " + header;
    }

    @GET
    @Path("cookie-param")
    public String cookieParamAnnotation(@CookieParam("cookie") String cookie)
    {
        return "Cookie Param value is " + cookie;
    }

    @GET
    @Path("context-http-header")
    public String contextHttpHeader(@Context HttpHeaders headers)
    {
        MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
        System.out.println("requestHeaders:");
        requestHeaders.values().stream().forEach(System.out::println);

        List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();
        System.out.println("acceptableMediaTypes:");
        acceptableMediaTypes.stream().forEach(System.out::println);

        List<Locale> acceptableLanguages = headers.getAcceptableLanguages();
        System.out.println("acceptableLanguages:");
        acceptableLanguages.stream().forEach(System.out::println);

        Date date = headers.getDate();
        System.out.println("Date:" + date);

        int length = headers.getLength();
        System.out.println("length: " + length);

        MediaType mediaType = headers.getMediaType();
        System.out.println("mediatype : " + mediaType);

        return "Look at the console logs!!";
    }


    @GET
    @Path("context-uri-info")
    public String contextUriInfo(@Context UriInfo uriInfo)
    {
        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
        System.out.println("queryParameters:");
        queryParameters.values().stream().forEach(System.out::println);

        MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
        System.out.println("pathParameters:");
        pathParameters.values().stream().forEach(System.out::println);

        URI absolutePath = uriInfo.getAbsolutePath();
        System.out.println("absolutePath:");
        System.out.println(absolutePath.toString());

        URI baseUri = uriInfo.getBaseUri();
        System.out.println("baseUri:");
        System.out.println(baseUri.toString());

        List<PathSegment> pathSegments = uriInfo.getPathSegments();
        System.out.println("pathSegments:");
        pathSegments.stream().forEach(System.out::println);

        URI requestUri = uriInfo.getRequestUri();
        System.out.println("requestUri:");
        System.out.println(requestUri.toString());

        return "Look at the console logs!!";
    }

}
