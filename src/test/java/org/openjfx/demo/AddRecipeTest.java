package org.openjfx.demo;
import entity.Recipes;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjfx.demo.AddRecipe;
import org.openjfx.demo.ShopController;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRecipeTest {
    private static AddRecipe addRecipe;
    private static ShopController shopController;
    private static SessionFactory sessionFactory;
    private static List<Recipes> allRecipes = new ArrayList<>();
    private static CountDownLatch latch = new CountDownLatch(1);

    @BeforeAll
    public static void setUp() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Platform.startup(() -> {
            addRecipe = new AddRecipe();
            shopController = new ShopController();
            sessionFactory = SessionFactoryProvider.provideSessionFactory();
            latch.countDown();
        });

        // Wait for JavaFX initialization to finish.
        latch.await(5, TimeUnit.SECONDS);
    }

    @Test
    public void testRecipeAdd_Success() {

        addRecipe.recipeTextField = new TextField();
        addRecipe.recipeDesciprtionField = new TextArea();
        addRecipe.sessionFactory = sessionFactory;
        addRecipe.shopController = shopController;

        Platform.runLater(() -> {
            addRecipe.recipeTextField.setText("asdasd");
            addRecipe.recipeDesciprtionField.setText("asdasdasd");
            addRecipe.RecipeAdd();
        });

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allRecipes = new GenericDAO<>(sessionFactory).retrieveAllRecipes();

        assertEquals(1, allRecipes.size());

        new GenericDAO<>(sessionFactory).delete(allRecipes.getFirst());
    }

    @Test
    public void testRecipeAdd_Fail() {
        addRecipe.recipeTextField = new TextField();
        addRecipe.recipeDesciprtionField = new TextArea();
        addRecipe.sessionFactory = sessionFactory;
        addRecipe.shopController = shopController;

        Platform.runLater(() -> {
            addRecipe.recipeTextField.setText("");
            addRecipe.recipeDesciprtionField.setText("");
            addRecipe.RecipeAdd();
        });

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allRecipes = new GenericDAO<>(sessionFactory).retrieveAllRecipes();

        assertEquals(0, allRecipes.size());

    }
}