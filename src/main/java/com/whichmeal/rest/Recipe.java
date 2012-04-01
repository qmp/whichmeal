
package com.whichmeal.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

/**
 *
 * @author qmp
 */
@Path("recipe")
public class Recipe {
    
    @GET
    @Path("{name}")
    public String byName(@PathParam("name") final String name){
        return "Im a recipe!" + name;
    }
}
