package org.openjfx.demo;

import entity.Recipes;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

public class AddRecipe extends SceneChanger {

    public TextField recipeTextField;
    public TextArea recipeDesciprtionField;

    private ShopController shopController;
    private final SessionFactory sessionFactory;
/*
    public AddItem(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    */

    public AddRecipe(Stage stage, SessionFactory sessionFactory, ShopController shopController) {
        super(stage);
        this.sessionFactory = sessionFactory;
        this.shopController = shopController;
    }

    public AddRecipe() {
        super(new Stage());
        sessionFactory = SessionFactoryProvider.provideSessionFactory();
    }
    public void RecipeAdd() {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);


        GenericDAO<Recipes> productsDAO = new GenericDAO<>(sessionFactory);
        Recipes product = new Recipes();
        product.setRecipeName(recipeTextField.getText());
        product.setDescription(recipeDesciprtionField.getText());
        if(recipeTextField.getText().isEmpty() || recipeDesciprtionField.getText().isEmpty()) {
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }
        productsDAO.create(product);

        alert.setContentText("Recipe created");
        alert.showAndWait();
        Stage currentStage = (Stage) recipeTextField.getScene().getWindow();
        currentStage.close();
        OpenScene("shop.fxml", "Shop");
    }
    public void BackToShop() {
        OpenScene("shop.fxml", "Shop");
    }
}
