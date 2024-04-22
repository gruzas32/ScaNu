package org.openjfx.demo;

import entity.Recipes;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MoreInfo extends SceneChanger{
    public TextField recipeNameField;
    private Recipes recipe;

    public MoreInfo() {
        super(new Stage());

    }
    public void initialize() {
        // Populate UI components with recipe details
        // For example:
        recipeNameField.setText(recipe.getRecipeName());
        //descriptionTextArea.setText(recipe.getDescription());
    }

}
