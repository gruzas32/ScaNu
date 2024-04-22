package org.openjfx.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import entity.LoggedUser;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openjfx.demo.GenericDAO;
import org.openjfx.demo.RegisterController;

import java.sql.Date;

@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {

    @InjectMocks
    private RegisterController controller;
    private Alert alert;
    @Test
    public void testRegisterUser_emptyFields() {
        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();

        controller.usernameField.setText("");
        controller.passwordField.setText("");
        controller.firstNameField.setText("");
        controller.lastNameField.setText("");

        controller.RegisterUser();
        assertEquals("Please fill all fields", alert.getContentText());
    }

    @Test
    public void testRegisterUser_emptyUsername() {
        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();
        controller.usernameField.setText("");
        controller.passwordField.setText("password123");
        controller.firstNameField.setText("John");
        controller.lastNameField.setText("Doe");

        controller.RegisterUser();
        assertEquals("Please fill all fields", alert.getContentText());
    }

    @Test
    public void testRegisterUser_emptyPassword() {
        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();
        controller.usernameField.setText("test_user");
        controller.passwordField.setText("");
        controller.firstNameField.setText("John");
        controller.lastNameField.setText("Doe");

        controller.RegisterUser();
        assertEquals("Please fill all fields", alert.getContentText());
    }

    @Test
    public void testRegisterUser_emptyFirstName() {
        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();
        controller.usernameField.setText("test_user");
        controller.passwordField.setText("password123");
        controller.firstNameField.setText("");
        controller.lastNameField.setText("Doe");

        controller.RegisterUser();
        assertEquals("Please fill all fields", alert.getContentText());
    }

    @Test
    public void testRegisterUser_emptyLastName() {
        controller = new RegisterController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.firstNameField = new TextField();
        controller.lastNameField = new TextField();
        controller.usernameField.setText("test_user");
        controller.passwordField.setText("password123");
        controller.firstNameField.setText("John");
        controller.lastNameField.setText("");

        controller.RegisterUser();
        assertEquals("Please fill all fields", alert.getContentText());
    }
   @Test
   public void testRegisterUser_success() throws Exception {
       controller = new RegisterController();
       controller.usernameField = new TextField();
         controller.passwordField = new PasswordField();
            controller.firstNameField = new TextField();
            controller.lastNameField = new TextField();


       String username = "test_user";
       String password = "password123";
       String firstName = "John";
       String lastName = "Doe";


       controller.usernameField.setText(username);
       controller.passwordField.setText(password);
       controller.firstNameField.setText(firstName);
       controller.lastNameField.setText(lastName);


       Users newUser = new Users();
       newUser.setUsername(username);
       newUser.setFirstName(firstName);
       newUser.setLastName(lastName);
       newUser.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));  // Hash password


       controller.RegisterUser();

       Users expectedUser = new Users();
       expectedUser.setUsername(username);
       expectedUser.setFirstName(firstName);
       expectedUser.setLastName(lastName);
       expectedUser.setPasswordHash(newUser.getPasswordHash());

       assertEquals(expectedUser.getUsername(), newUser.getUsername());
       assertEquals(expectedUser.getFirstName(), newUser.getFirstName());
       assertEquals(expectedUser.getLastName(), newUser.getLastName());
       assertTrue(BCrypt.checkpw(password, newUser.getPasswordHash()));


   }

    @Test
    public void testHashPassword() {
        String plainPassword = "password123";
        String hashedPassword = controller.hashPassword(plainPassword);

        assertNotEquals(plainPassword, hashedPassword);

        assertTrue(BCrypt.checkpw(plainPassword, hashedPassword));
    }
}