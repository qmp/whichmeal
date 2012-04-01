package ch.bfh.whichmeal;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

/**
 *
 * @author Boris Matti
 */
@Entity
public class Recipe implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(nullable=false)
    private String name;
    // short description
    @Basic
    private String description;
    // instructions
    @Basic
    private String recipe;
    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> lstIngredients = new ArrayList<String>();
    
    public Recipe(){}

    public Recipe(ArrayList<String> lstIngredients, String recipe)
    {
        this.lstIngredients = lstIngredients;
        this.recipe = recipe;
    }

    public List<String> getLstIngredients() {
        return lstIngredients;
    }
    
    public void setLstIngredients(ArrayList<String> lstIngredients){
        this.lstIngredients = lstIngredients;
    }

    public String getRecipe() {
        return recipe;
    }
    
    public void setRecipe(String recipe){
        this.recipe = recipe;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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
