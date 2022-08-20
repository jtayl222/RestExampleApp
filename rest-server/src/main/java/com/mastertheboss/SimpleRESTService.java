package com.mastertheboss;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api")
public class SimpleRESTService {
    Logger log = LoggerFactory.getLogger(SimpleRESTService.class);
    @GET
    @Path("/text")
    public String getHello () 
    {
        log.info("call to getHello()");
        return "hello world!";
    } 
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON () 
    {
        log.info("call to getPropertyJSON()");
        SimpleProperty p = new SimpleProperty(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return p;
    }
   
}