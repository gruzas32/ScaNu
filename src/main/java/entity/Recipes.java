package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Recipes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recipe_id")
    private int recipeId;
   @Basic
    @Column(name = "recipe_name")
    private String recipeName;
    @Basic
    @Column(name = "description")
    private String description;


    public Recipes(String recipeName, String description) {
        this.recipeName = recipeName;
        this.description = description;

    }

    public Recipes() {

    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int productId) {
        this.recipeId = productId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String productName) {
        this.recipeName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes products = (Recipes) o;
        return recipeId == products.recipeId && Objects.equals(recipeName, products.recipeName) && Objects.equals(description, products.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, description);
    }
}
