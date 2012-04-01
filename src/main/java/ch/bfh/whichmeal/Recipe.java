package ch.bfh.whichmeal;

import java.util.ArrayList;

/**
 *
 * @author Boris Matti
 */
public class Recipe {
    
    private int id;
    private String name;
    private String description;
    private String recipe;
    private ArrayList<String> lstIngredients = new ArrayList<String>();

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
    
    @Override
    public String toString()
    {
        return name;
    }
}
