
package com.whichmeal.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    @PersistenceContext(unitName="whichmeal")
    EntityManager em;
    String name;
    
    @GET
    @Path("by_id/{id}")
    public Recipe byId(@PathParam("id") final int id) {
        if (em == null)
                return null;
        
        Recipe recipe = em.find(Recipe.class, id);
        return recipe;
    }
}
