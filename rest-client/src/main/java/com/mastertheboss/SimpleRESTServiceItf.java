package com.mastertheboss;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="hello-service")
@ApplicationScoped
@Path("/api")
public interface SimpleRESTServiceItf {
    @GET
    @Path("/text")
    public String getHello();

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON();
}