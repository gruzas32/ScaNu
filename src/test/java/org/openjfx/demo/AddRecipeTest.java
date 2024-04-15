import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjfx.demo.AddRecipe;
import org.openjfx.demo.GenericDAO;
import org.openjfx.demo.SessionFactoryProvider;
import entity.Recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRecipeTest {

    @BeforeAll
    public static void setUp() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
    }

    @Test
    public void testRecipeAdd_ValidInput_Success() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = "Pasta";
        String description = "Delicious pasta recipe";

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(1, countRecipes());
    }

    @Test
    public void testRecipeAdd_EmptyInput_Fail() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = "";
        String description = "";

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(0, countRecipes());
    }

    @Test
    public void testRecipeAdd_NullInput_Fail() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = null;
        String description = null;

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(0, countRecipes());
    }


    @Test
    public void testRecipeAdd_EmptyRecipeName_Fail() {
        // Prepare empty input
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = "";
        String description = "asdasdasdasdas";

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(0, countRecipes());
    }

    @Test
    public void testRecipeAdd_EmptyRecipeDesc_Fail() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = "asasasasa";
        String description = "";

        // Perform action
        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(0, countRecipes());
    }
    @Test
    public void testRecipeAdd_OnlyWhiteSpaceName_Fail() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = " ";
        String description = "sasasasasa";

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();

        assertEquals(0, countRecipes());
    }

    @Test
    public void testRecipeAdd_OnlyWhiteSpaceDesc_Fail() {
        AddRecipe addRecipe = new AddRecipe();
        String recipeName = "asasasasa";
        String description = " ";

        addRecipe.setRecipeName(recipeName);
        addRecipe.setDescription(description);
        addRecipe.addRecipe();


        assertEquals(0, countRecipes());
    }

    private int countRecipes() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        return new GenericDAO<>(sessionFactory).retrieveAllRecipes().size();
    }
}
