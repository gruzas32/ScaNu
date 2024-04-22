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
public class E2E_LoginTests extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoginApplication().start(stage);
    }

    @Test
    public void test_LoginWithInvalidCredentials() {
        clickOn("#login").write("aasdasdas");
        clickOn("#password").write("aasdasdasd");
        clickOn("#loginButton");
        verifyThat("Neteisingas prisijungimo vardas arba slaptažodis!", isVisible());
    }

    @Test
    public void test_LoginWithValidCredentials() {
        clickOn("#login").write("a");
        clickOn("#password").write("a");

        clickOn("#loginButton");

        verifyThat("#receptaiTabId", isVisible());
    }

    @Test
    public void test_LoginWithEmptyFields() {
        clickOn("#loginButton");
        verifyThat("Prašome užpildyti visus laukus", isVisible());
    }
}
