package entity;

import jakarta.persistence.*;

@Entity
public class SavedRecipes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "user_id")
    private int userId;

    public SavedRecipes(int id, int recipeId, int userId) {
        this.id = id;
        this.recipeId = recipeId;
        this.userId = userId;
    }

    public SavedRecipes() {

    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
