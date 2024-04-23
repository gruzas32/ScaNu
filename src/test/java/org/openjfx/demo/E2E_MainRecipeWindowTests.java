package org.openjfx.demo;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjfx.demo.ShopController;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.isVisible;

public class E2E_MainRecipeWindowTests extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoginApplication().start(stage);
    }

    @Test
    public void test_DeleteRecipe() {
        clickOn("#login").write("a");
        clickOn("#password").write("a");

        clickOn("#loginButton");

        int initialSize = ((TableView) lookup("#RecipesTableView").query()).getItems().size();

        clickOn("#RecipesTableView").clickOn("1");
        clickOn("#deleteButton");

        int finalSize = ((TableView) lookup("#RecipesTableView").query()).getItems().size();

        assertTrue(finalSize < initialSize);
    }

    @Test
    public void test_editRecipeName()
    {
        clickOn("#login").write("a");
        clickOn("#password").write("a");

        clickOn("#loginButton");

        clickOn("#RecipesTableView").clickOn("1");
        String recipeName = ((TextField) lookup("#editRecipeF").query()).getText();

        clickOn("#editRecipeF").write("kazkas");
        clickOn("#editButton");

        clickOn("#RecipesTableView").clickOn("1");
        String recipeName2 = ((TextField) lookup("#editRecipeF").query()).getText();

          assertTrue(!recipeName.equals(recipeName2));
    }


}
