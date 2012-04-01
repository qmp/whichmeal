
package com.whichmeal.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ch.bfh.whichmeal.Recipe;


/**
 *
 * @author qmp
 */
@Path("json/recipe")
@Produces("Application/json")
public class RecipeService{
    String name;
    
    @GET
    @Path("{name}")
    public Recipe byName(@PathParam("name") final String name){
        Recipe recipe = new Recipe();
        recipe.setName(name);
        return recipe;
    }
}
