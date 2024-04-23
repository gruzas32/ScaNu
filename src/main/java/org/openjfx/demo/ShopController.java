package org.openjfx.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import entity.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class ShopController extends SceneChanger {

    public TableView<Recipes> RecipesTableView;
    public TableView<Recipes> RecipesTableView2;
    public TextField recipeNameField;
    public List<Recipes> recipesList;
    public List<Rating> ratingList;
    private final SessionFactory sessionFactory;
    public Button addButton;
    public Button deleteButton;
    public Button editButton;
    public TextField editRecipeF;
    public TextField editDescriptionF;
    public TextField commentField;
    public CheckBox onestar;
    public CheckBox twostars;
    public CheckBox fivestars;
    public CheckBox fourstars;
    public CheckBox threestars;
    public Button filterButton;
    public Button filterBTN;
    public CheckBox onestarR;
    public CheckBox twostarsR;
    public CheckBox fivestarsR;
    public CheckBox fourstarsR;
    public CheckBox threestarsR;

    public TableView CommentsTableView;
    public TextField commentField1;
    public TextField recipeNameField1;
    public Button moreInfoButton;
    public SavedRecipes savedRecipes;
    public TableView savedRecipesView;
    public CheckBox cheesebox1;
    public CheckBox cucumberBox1;
    public CheckBox sugarBox1;
    public CheckBox waterBox1;
    public CheckBox sphagetiBox1;

    public CheckBox flourBox1;

    private List<LoggedUser> allLoggedUsers;
    public List<SavedRecipes>savedRecipesList;

    public int userId;
    @FXML
    public void initialize() {
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        allLoggedUsers = loggedUsersDAO.retrieveAllLoggedUsers();
        for (LoggedUser logged : allLoggedUsers) {
            if (logged.isLogged() == true){
                userId = logged.getUserId();
            }
        }
        recipesList = new GenericDAO<>(sessionFactory).retrieveAllRecipes();
        ratingList = new GenericDAO<>(sessionFactory).RetrieveAllRatings();
        savedRecipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnUserId(userId);
        RecipesTableView.getItems().addAll(recipesList);
        RecipesTableView2.getItems().addAll(recipesList);
        CommentsTableView.getItems().addAll(ratingList);
        savedRecipesView.getItems().addAll(savedRecipesList);
    }

    public ShopController() {
        super(new Stage());
        sessionFactory = SessionFactoryProvider.provideSessionFactory();
    }

    public ShopController(Stage stage, SessionFactory sessionFactory) {
        super(stage);
        this.sessionFactory = sessionFactory;
    }

    public void openAddItem() {
        Stage currentStage = (Stage) RecipesTableView.getScene().getWindow();
        currentStage.close();
        OpenScene("addRecipe.fxml", "Pridėti receptą");
    }

    public void EditRecipeItem() {

        Recipes selectedProduct = RecipesTableView.getSelectionModel().getSelectedItem();
        selectedProduct.setRecipeName(editRecipeF.getText());
        selectedProduct.setDescription(editDescriptionF.getText());
        new GenericDAO<>(sessionFactory).update(selectedProduct);
        RecipesTableView.refresh();
    }


    public void DeleteRecipe() {
        Recipes recipes = RecipesTableView.getSelectionModel().getSelectedItem();
        new GenericDAO<>(sessionFactory).delete(recipes);
        RecipesTableView.getItems().remove(recipes);
        RecipesTableView2.getItems().remove(recipes);
    }

    public void loadProductsField(MouseEvent mouseEvent) {

        Recipes selectedWarehouse = RecipesTableView.getSelectionModel().getSelectedItem();
        editRecipeF.setText(selectedWarehouse.getRecipeName());
        editDescriptionF.setText(selectedWarehouse.getDescription());
    }

    public void closeProgram() {
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        allLoggedUsers = loggedUsersDAO.retrieveAllLoggedUsers();
        for (LoggedUser logged : allLoggedUsers) {
            logged.setLogged(false);
            loggedUsersDAO.update(logged);
        }

        Stage currentStage = (Stage) RecipesTableView.getScene().getWindow();
        currentStage.close();
    }
    public void SortByProductName(){
        String text = recipeNameField.getText();
        recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnName(text);
        RecipesTableView2.getItems().clear();
        RecipesTableView2.getItems().addAll(recipesList);

    }
    public void refreshButton(){
        recipesList = new GenericDAO<>(sessionFactory).retrieveAllRecipes();
        RecipesTableView2.getItems().clear();
        RecipesTableView2.getItems().addAll(recipesList);
        savedRecipesView.getItems().addAll();
    }

    public void SortByRating(){

            if (onestarR.isSelected()) {
                ratingList = new GenericDAO<>(sessionFactory).RetrieveRatingsBasedOnRating(1);
            }
            if (twostarsR.isSelected()) {
                ratingList = new GenericDAO<>(sessionFactory).RetrieveRatingsBasedOnRating(2);
            }
            if (threestarsR.isSelected()) {
                ratingList = new GenericDAO<>(sessionFactory).RetrieveRatingsBasedOnRating(3);
            }
            if (fourstarsR.isSelected()) {
                ratingList = new GenericDAO<>(sessionFactory).RetrieveRatingsBasedOnRating(4);
            }
            if (fivestarsR.isSelected()) {
                ratingList = new GenericDAO<>(sessionFactory).RetrieveRatingsBasedOnRating(5);
            }
            CommentsTableView.getItems().clear();
            CommentsTableView.getItems().addAll(ratingList);
        }

    public void backToLogin(){
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        allLoggedUsers = loggedUsersDAO.retrieveAllLoggedUsers();
        for (LoggedUser logged : allLoggedUsers) {
            logged.setLogged(false);
            loggedUsersDAO.update(logged);
        }
        Stage currentStage = (Stage) RecipesTableView.getScene().getWindow();
        currentStage.close();
        OpenScene("login.fxml", "Prisijungimas");
    }
    public void addRating(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String text = commentField.getText();
        if(text.isEmpty()){
            alert.setTitle("Klaida");
            alert.setHeaderText(null);
            alert.setContentText("Užpildykite visus laukus.");
            alert.showAndWait();
            return;
        }
        GenericDAO<Rating> ratingGenericDAODAO = new GenericDAO<>(sessionFactory);
        Rating rating = new Rating();
        rating.setComment(commentField.getText());
        if(onestar.isSelected()==false && twostars.isSelected()==false && threestars.isSelected()==false && fourstars.isSelected()==false && fivestars.isSelected()==false){
            alert.setTitle("Įvertinimas");
            alert.setHeaderText(null);
            alert.setContentText("Prašau pasirinkite įvertinimą.");
            alert.showAndWait();
            return;
        }
        if(onestar.isSelected()&& twostars.isSelected() || onestar.isSelected()&& threestars.isSelected() || onestar.isSelected()&& fourstars.isSelected() || onestar.isSelected()&& fivestars.isSelected() || twostars.isSelected()&& threestars.isSelected() || twostars.isSelected()&& fourstars.isSelected() || twostars.isSelected()&& fivestars.isSelected() || threestars.isSelected()&& fourstars.isSelected() || threestars.isSelected()&& fivestars.isSelected() || fourstars.isSelected()&& fivestars.isSelected()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please select only one rating");
            alert.showAndWait();
            return;
        }
        if(onestar.isSelected()){
            rating.setRating(1);
        }
        if(twostars.isSelected()){
            rating.setRating(2);
        }
        if(threestars.isSelected()){
            rating.setRating(3);
        }
        if(fourstars.isSelected()){
            rating.setRating(4);
        }
        if(fivestars.isSelected()){
            rating.setRating(5);
        }
        rating.setRecipeId(RecipesTableView2.getSelectionModel().getSelectedItem().getRecipeId());
        rating.setUserId(userId);
        ratingGenericDAODAO.create(rating);
        alert.setTitle("Įvertinimas");
        alert.setHeaderText(null);
        alert.setContentText("Įvertinimas pridėtas");
        alert.showAndWait();
    }

    public void loadCommentsField(MouseEvent mouseEvent) {
        Rating selectedWarehouse = (Rating) CommentsTableView.getSelectionModel().getSelectedItem();
        commentField1.setText(selectedWarehouse.getComment());
        onestarR.setSelected(false);
        twostarsR.setSelected(false);
        threestarsR.setSelected(false);
        fourstarsR.setSelected(false);
        fivestarsR.setSelected(false);

        if(selectedWarehouse.getRating()==1){
            onestarR.setSelected(true);
        }
        if(selectedWarehouse.getRating()==2){
            twostarsR.setSelected(true);
        }
        if(selectedWarehouse.getRating()==3){
            threestarsR.setSelected(true);
        }
        if(selectedWarehouse.getRating()==4){
            fourstarsR.setSelected(true);
        }
        if(selectedWarehouse.getRating()==5){
            fivestarsR.setSelected(true);
        }
    }
    public void hideSelectedRecipefromTable(){
        Recipes selectedRecipe = RecipesTableView.getSelectionModel().getSelectedItem();
        RecipesTableView.getItems().remove(selectedRecipe);

    }
    public void openMoreInfo(){
        // Get the selected recipe
        Recipes selectedRecipe = RecipesTableView.getSelectionModel().getSelectedItem();

        // Close the current stage
        Stage currentStage = (Stage) RecipesTableView.getScene().getWindow();
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("moreAboutRecipe.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

            // Get the controller of moreAboutRecipe
            moreAboutRecipe controller = loader.getController();

            // Pass the selected recipe to moreAboutRecipe controller
            controller.setRecipe(selectedRecipe, sessionFactory);

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteSavedRecipe(){
        SavedRecipes selectedRecipe = (SavedRecipes) savedRecipesView.getSelectionModel().getSelectedItem();
        new GenericDAO<>(sessionFactory).delete(selectedRecipe);
        savedRecipesView.getItems().remove(selectedRecipe);
    }
    public void FilterByIngredients(){


        if (cheesebox1.isSelected()) {
                 recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false);
        }
       else if (cucumberBox1.isSelected()) {
            recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false);
        }
        else if (sugarBox1.isSelected()) {
            recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false);
        }
       else if (waterBox1.isSelected()) {
            recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false);
        }
        else if (sphagetiBox1.isSelected()) {
            recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false);
        }
        else if (flourBox1.isSelected()) {
            recipesList = new GenericDAO<>(sessionFactory).retrieveRecipesBasedOnCheckBoxes(false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false);
        }
        RecipesTableView2.getItems().addAll(recipesList);
    }



    public void AddSavedRecipe(){
        SavedRecipes savedRecipes = new SavedRecipes();
        savedRecipes.setRecipeId(RecipesTableView.getSelectionModel().getSelectedItem().getRecipeId());
        savedRecipes.setUserId(userId);
        new GenericDAO<>(sessionFactory).create(savedRecipes);
    }

    public void refreshComments() {
        ratingList = new GenericDAO<>(sessionFactory).RetrieveAllRatings();
        CommentsTableView.getItems().clear();
        CommentsTableView.getItems().addAll(ratingList);

    }
    public void refreshRecipeTables()
    {
        recipesList = new GenericDAO<>(sessionFactory).retrieveAllRecipes();
        RecipesTableView.getItems().clear();
        RecipesTableView.getItems().addAll(recipesList);
        savedRecipesView.getItems().clear();
        savedRecipesView.getItems().addAll(savedRecipesList);

    }

    public void duplicateSelectedItem(ActionEvent actionEvent) {
Recipes selectedRecipe = RecipesTableView.getSelectionModel().getSelectedItem();
        Recipes newRecipe = new Recipes();
        newRecipe.setRecipeName(selectedRecipe.getRecipeName());
        newRecipe.setDescription(selectedRecipe.getDescription());
        new GenericDAO<>(sessionFactory).create(newRecipe);
        RecipesTableView.getItems().add(newRecipe);
        refreshRecipeTables();


    }
}
