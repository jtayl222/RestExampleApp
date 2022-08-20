package com.mastertheboss;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/proxy")
@ApplicationScoped
public class SimpleRESTEndpoint {
    Logger log = LoggerFactory.getLogger(SimpleRESTEndpoint.class);

    @Inject
    @RestClient
    SimpleRESTServiceItf simpleRESTServiceItf;
    @GET
    @Path("/text")
    public String getHello() {
        log.info("getHello()");
        return simpleRESTServiceItf.getHello();
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON(){
        log.info("getPropertyJSON()");
        return simpleRESTServiceItf.getPropertyJSON();
    } 
}