package org.openjfx.demo;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.*;
import org.openjfx.demo.LoginApplication;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;
import static org.testfx.util.NodeQueryUtils.isVisible;

public class E2E_RegistrationTests extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoginApplication().start(stage);
    }

    @Test
    public void test_NewUserRegistration() {
        clickOn("#userRegistrationButton");

        clickOn("#firstNameField").write("asa");
        clickOn("#lastNameField").write("dasdasASasdasd");
        clickOn("#usernameField").write("sASSas");
        clickOn("#passwordField").write("asdsasaasdasd");
        clickOn("#registerUserButton");

        verifyThat("Naudotojas sukurtas!", isVisible());

    }

    @Test
    public void test_RegisterExistingUser()
    {
        clickOn("#userRegistrationButton");

        clickOn("#firstNameField").write("a");
        clickOn("#lastNameField").write("a");
        clickOn("#usernameField").write("a");
        clickOn("#passwordField").write("a");
        clickOn("#registerUserButton");

        verifyThat("Vartotojas toks jau egzistuoja. Prašome įvesti kitą vartotojo vardą.", isVisible());
    }

    @Test
    public void test_RegisterEmptyFields() {
        clickOn("#userRegistrationButton");

        clickOn("#registerUserButton");

        verifyThat("Please fill all fields", isVisible());
    }
}
