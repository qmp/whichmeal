package ch.bfh.whichmeal;

import java.util.ArrayList;

/**
 *
 * @author Boris Matti
 */
public class Recipe {
    
    private int id;
    private String name;
    // short description
    private String description;
    // instructions
    private String recipe;
    private ArrayList<String> lstIngredients = new ArrayList<String>();
    
    public Recipe(){}

    public Recipe(ArrayList<String> lstIngredients, String recipe)
    {
        this.lstIngredients = lstIngredients;
        this.recipe = recipe;
    }

    public ArrayList<String> getLstIngredients() {
        return lstIngredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
}
