package com.restapp

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("helloworld")
class HelloWorld {

    @GET
    @Produces("application/json")
    @Path("path")
    String helloWorld(){
        return "Hello World"
    }

}
