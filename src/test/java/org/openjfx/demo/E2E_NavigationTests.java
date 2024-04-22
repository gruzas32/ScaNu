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

public class E2E_NavigationTests extends ApplicationTest {
    @BeforeAll
    public static void setUpClass() throws Exception {
        FxToolkit.registerPrimaryStage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        new LoginApplication().start(stage);
    }

    @Test
    public void test_NavigationToRegistration() {
        clickOn("#userRegistrationButton");
        verifyThat("#registerUserButton", isVisible());
    }

    @Test
    public void test_NavigationBackToLogin() {
        clickOn("#userRegistrationButton");
        clickOn("#backToLoginButton");
        verifyThat("#loginButton", isVisible());
    }
}
