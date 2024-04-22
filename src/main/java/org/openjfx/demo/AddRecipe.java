package org.openjfx.demo;

import entity.Recipes;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

public class AddRecipe extends SceneChanger {

    public TextField recipeTextField;
    public TextArea recipeDesciprtionField;
    public CheckBox cucumberCheckBox;
    public CheckBox potatoCheckBox;
    public CheckBox waterCheckBox;
    public CheckBox onionCheckBox;
    public CheckBox cheeseCheckBox;
    public CheckBox easterCheckBox;
    public CheckBox nightSnackCheckBox;
    public CheckBox snackCheckBox;
    public CheckBox breakfastCheckBox;
    public CheckBox nightFoodCheckBox;
    public CheckBox newYearCheckBox;
    public CheckBox christmasCheckBox;
    public CheckBox bbqCheckBox;
    public CheckBox spaghettiCheckBox;
    public CheckBox salamiCheckBox;
    public CheckBox riddikCheckBox;
    public CheckBox milkCheckBox;
    public CheckBox ketchupCheckBox;
    public CheckBox tomatoCheckBox;
    public CheckBox carrotCheckBox;
    public CheckBox flourCheckBox;
    public CheckBox calenderCheckBox;
    public CheckBox creamCheckBox;
    public CheckBox pastaCheckBox;
    public CheckBox mayoCheckBox;
    public CheckBox sausageCheckBox;
    public CheckBox sugarCheckBox;
    public CheckBox cabbageCheckBox;
    public CheckBox eggCheckBox;

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
        if(cucumberCheckBox.isSelected()){
            product.setCucumber(true);
        }
        if(potatoCheckBox.isSelected()){
            product.setPotatoes(true);
        }
        if(waterCheckBox.isSelected()){
            product.setWater(true);
        }
        if(onionCheckBox.isSelected()){
            product.setOnion(true);
        }
        if(cheeseCheckBox.isSelected()){
            product.setCheese(true);
        }
        if(easterCheckBox.isSelected()){
            product.setEvening(true);
        }
        if(nightSnackCheckBox.isSelected()){
            product.setDinner(true);
        }
        if(snackCheckBox.isSelected()){
            product.setSnack(true);
        }
        if(breakfastCheckBox.isSelected()){
            product.setBreakfast(true);
        }
        if(nightFoodCheckBox.isSelected()){
            product.setNightfood(true);
        }
        if(newYearCheckBox.isSelected()){
            product.setNewyear(true);
        }
        if(christmasCheckBox.isSelected()){
            product.setChristmas(true);
        }
        if(bbqCheckBox.isSelected()){
            product.setBbq(true);
        }
        if(spaghettiCheckBox.isSelected()){
            product.setSpaghetti(true);
        }
        if(salamiCheckBox.isSelected()){
            product.setSaliami(true);
        }
        if(riddikCheckBox.isSelected()){
            product.setRadish(true);
        }
        if(milkCheckBox.isSelected()){
            product.setMilk(true);
        }
        if(ketchupCheckBox.isSelected()){
            product.setTomatosauce(true);
        }
        if(tomatoCheckBox.isSelected()){
            product.setTomato(true);
        }
        if(carrotCheckBox.isSelected()){
            product.setCarrot(true);
        }
        if(flourCheckBox.isSelected()){
            product.setFlour(true);
        }
        if(calenderCheckBox.isSelected()){
            product.setCalendar(true);
        }
        if(creamCheckBox.isSelected()){
            product.setCream(true);
        }
        if(pastaCheckBox.isSelected()){
            product.setMacaroni(true);
        }
        if(mayoCheckBox.isSelected()){
           product.setMayo(true);
        }
        if(sausageCheckBox.isSelected()){
            product.setSausage(true);
        }
        if(sugarCheckBox.isSelected()){
            product.setSugar(true);
        }
        if(cabbageCheckBox.isSelected()){
            product.setCabbage(true);
        }
        if(eggCheckBox.isSelected()){
            product.setEggs(true);
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
