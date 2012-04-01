
package com.whichmeal.rest;

import javax.ejb.Stateless;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
@Stateless
public class RecipeService{
    @PersistenceContext(unitName="whichmeal")
    EntityManager em;
    
    @GET
    @Path("by_id/{id}")
    public Recipe byId(@PathParam("id") final int id) {
        Recipe recipe = em.find(Recipe.class, id);
        return recipe;
    }
    
    @GET
    @Path("by_keyword/{keyword}")
    public List<RecipeSummary> byKeyword(@PathParam("keyword") final String keyword){
        String upperKeyword = keyword.toUpperCase();
        Query query = em.createQuery("from Recipe r where upper(r.name) like :keyword");
        query.setParameter("keyword", "%" + upperKeyword + "%");
        List<RecipeSummary> result = new ArrayList<RecipeSummary>();
        List<Recipe> recipes = query.getResultList();
        for (Recipe recipe : recipes){
            result.add(new RecipeSummary(recipe.getId(), recipe.getName()));
        }
        return result;
    }
    
    @GET
    @Path("delete/{id}")
    public Recipe delete(@PathParam("id") final int id){
        Recipe recipe = em.find(Recipe.class, id);
        if (recipe != null){
            em.remove(recipe);
        }
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
