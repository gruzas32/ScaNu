package org.openjfx.demo;

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
    public ComboBox recipeCMB;
    public TableView CommentsTableView;
    public TextField commentField1;
    public TextField recipeNameField1;
    public Button moreInfoButton;


    private List<LoggedUser> allLoggedUsers;


    @FXML
    public void initialize() {
        recipesList = new GenericDAO<>(sessionFactory).retrieveAllRecipes();
        ratingList = new GenericDAO<>(sessionFactory).RetrieveAllRatings();
        RecipesTableView.getItems().addAll(recipesList);
        RecipesTableView2.getItems().addAll(recipesList);
        CommentsTableView.getItems().addAll(ratingList);
        loadRecipes();
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
        OpenScene("addRecipe.fxml", "Add Recipe");
    }

    public void EditRecipeItem() {

        Recipes selectedProduct = RecipesTableView.getSelectionModel().getSelectedItem();
        selectedProduct.setRecipeName(editRecipeF.getText());
        selectedProduct.setDescription(editDescriptionF.getText());
        new GenericDAO<>(sessionFactory).update(selectedProduct);
        RecipesTableView.refresh();
    }


    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public void DeleteRecipe() {
        Recipes recipes = RecipesTableView.getSelectionModel().getSelectedItem();
        new GenericDAO<>(sessionFactory).delete(recipes);
        RecipesTableView.getItems().remove(recipes);
    }

    public void loadProductsField(MouseEvent mouseEvent) {

        Recipes selectedWarehouse = RecipesTableView.getSelectionModel().getSelectedItem();
        editRecipeF.setText(selectedWarehouse.getRecipeName());
        editDescriptionF.setText(selectedWarehouse.getDescription());
    }

    public void exit() {
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
        OpenScene("login.fxml", "Login");
    }
    public void addRating(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        GenericDAO<Users> usersDAO = new GenericDAO<>(sessionFactory);
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        int userId = 0;
        allLoggedUsers = loggedUsersDAO.retrieveAllLoggedUsers();
        for (LoggedUser logged : allLoggedUsers) {
            if (logged.isLogged() == true){
                 userId = logged.getUserId();
            }
        }
        String text = commentField.getText();
        if(text.isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }
        GenericDAO<Rating> ratingGenericDAODAO = new GenericDAO<>(sessionFactory);
        Rating rating = new Rating();
        rating.setComment(commentField.getText());
        if(onestar.isSelected()==false && twostars.isSelected()==false && threestars.isSelected()==false && fourstars.isSelected()==false && fivestars.isSelected()==false){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please select a rating");
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
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Rating added");
        alert.showAndWait();
    }
    public void loadCommentsField(MouseEvent mouseEvent) {
        Rating selectedWarehouse = (Rating) CommentsTableView.getSelectionModel().getSelectedItem();
        commentField1.setText(selectedWarehouse.getComment());
        recipeNameField1.setText(new GenericDAO<>(sessionFactory).retrieveRecipeById(selectedWarehouse.getRecipeId()).getRecipeName());
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
    public void openMoreInfo(){
        Recipes selectedRecipe = RecipesTableView.getSelectionModel().getSelectedItem();
        // Instantiate RecipeDetailsController and pass the selected recipe
        MoreInfo controller = new MoreInfo(selectedRecipe);
        // Load RecipeDetails.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RecipeDetails.fxml"));
        loader.setController(controller);

        Stage currentStage = (Stage) RecipesTableView.getScene().getWindow();
        currentStage.close();
        OpenScene("moreAboutRecipe.fxml", "More Info");
    }
    public void loadRecipes() {
        List<Recipes> recipes = new GenericDAO<>(sessionFactory).retrieveAllRecipes();
        for (Recipes recipe : recipes) {
            recipeCMB.getItems().add(recipe.getRecipeName());
        }
    }
}