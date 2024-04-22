package org.openjfx.demo;

import entity.Rating;
import entity.Recipes;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

import java.util.List;

public class moreAboutRecipe {


    public TextField recipeNameMore;
    public TextArea recipeDescriptionMore;
    public TableView<Rating> recipeRatingTableMore;


    public void setRecipe(Recipes selectedItem, SessionFactory sessionFactory) {
        recipeNameMore.setText(selectedItem.getRecipeName());
        recipeDescriptionMore.setText(selectedItem.getDescription());
        int recipeId = selectedItem.getRecipeId();
        List<Rating> ratings = new GenericDAO<>(sessionFactory).retrieveAllRatingsByRecipeId(recipeId);
        recipeRatingTableMore.getItems().addAll(ratings);

    }


    public void backToMainPage(ActionEvent actionEvent) {
        Stage stage = (Stage) recipeNameMore.getScene().getWindow();
        SceneChanger sceneChanger = new SceneChanger(stage);
        sceneChanger.OpenScene("shop.fxml", "Shop");


    }
}
