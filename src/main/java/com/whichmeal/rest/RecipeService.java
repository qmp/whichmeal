
package com.whichmeal.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ch.bfh.whichmeal.Recipe;


/**
 *
 * @author qmp
 */
@Path("json/recipe")
@Produces("Application/json")
public class RecipeService{
    @PersistenceContext(unitName="whichmeal")
    EntityManager em;
    
    @GET
    @Path("by_id/{id}")
    public Recipe byId(@PathParam("id") final int id) {
        Recipe recipe = em.find(Recipe.class, id);
        return recipe;
    }
    
    @POST
    @Path("/add")
    @Consumes("Application/json")
    public Response add(Recipe recipe){
        em.persist(recipe);
        em.flush();
        String result = "Recipe added : " + recipe;
        return Response.status(201).entity(result).build();
    }
}
