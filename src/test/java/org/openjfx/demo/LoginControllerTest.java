package org.openjfx.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void succsesfulLogin() {
        String login = "a";
        String password = "a";
        Assertions.assertEquals("a", login);
        Assertions.assertEquals("a", password);
    }

    @Test
    void unsuccsesfulLogin() {
        String login = "a";
        String password = "a";
        Assertions.assertEquals("a", login);
        Assertions.assertEquals("b", password);
    }


}