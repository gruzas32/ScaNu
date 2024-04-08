package org.openjfx.demo;

import entity.Recipes;
import javafx.scene.control.TextField;

public class MoreInfo {
    public TextField recipeNameField;
    private Recipes recipe;

    public MoreInfo(Recipes recipe) {
        this.recipe = recipe;
    }
    public void initialize() {
        // Populate UI components with recipe details
        // For example:
        recipeNameField.setText(recipe.getRecipeName());
        //descriptionTextArea.setText(recipe.getDescription());
    }

}
