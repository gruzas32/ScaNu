package org.openjfx.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjfx.demo.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    private final String validUsername = "a";
    private final String validPassword = "a";

    @Test
    public void testValidLogin() {
        LoginController loginService = new LoginController();
        assertTrue(loginService.UserLogin(validUsername, validPassword));
    }

    @Test
    public void testinvalidusername() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin("invalidUsername", validPassword));
    }

    @Test
    public void testInvalidPassword() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin(validUsername, "invalidPassword"));
    }

    @Test
    public void testEmptyUsername() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin("", validPassword));
    }

    @Test
    public void testEmptyPassword() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin(validUsername, ""));
    }

    @Test
    public void testNullUsername() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin(null, validPassword));
    }

    @Test
    public void testNullPassword() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin(validUsername, null));
    }
    @Test
    public void testWhiteSpaceUsername() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin("         ", validPassword));
    }

    @Test
    public void testWhiteSpacePassword() {
        LoginController loginService = new LoginController();
        assertFalse(loginService.UserLogin(validUsername, "         "));
    }
}

