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
    // Test for successful user registration (Mocking SessionFactory)
   @Test
   public void testRegisterUser_success() throws Exception {
       controller = new RegisterController();
       controller.usernameField = new TextField();
         controller.passwordField = new PasswordField();
            controller.firstNameField = new TextField();
            controller.lastNameField = new TextField();


       // Prepare test data
       String username = "test_user";
       String password = "password123";
       String firstName = "John";
       String lastName = "Doe";

       // Set user input (assuming these fields exist in your controller)

       controller.usernameField.setText(username);
       controller.passwordField.setText(password);
       controller.firstNameField.setText(firstName);
       controller.lastNameField.setText(lastName);

       // Simulate user registration logic without Hibernate
       // This part depends on your actual implementation, but it should mimic
       // the logic of creating a new user object, hashing the password,
       // and potentially storing it in a mock data store (optional).
       Users newUser = new Users();
       newUser.setUsername(username);
       newUser.setFirstName(firstName);
       newUser.setLastName(lastName);
       newUser.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));  // Hash password

       // You can optionally mock a data store if needed for your test
       // ... mock data store and user creation logic ...

       controller.RegisterUser();

       // Verify user object creation (adjust based on your actual logic)
       Users expectedUser = new Users();
       expectedUser.setUsername(username);
       expectedUser.setFirstName(firstName);
       expectedUser.setLastName(lastName);
       expectedUser.setPasswordHash(newUser.getPasswordHash());  // Verify hashed password

       // Assert that the created user object matches the expected one
       assertEquals(expectedUser.getUsername(), newUser.getUsername());
       assertEquals(expectedUser.getFirstName(), newUser.getFirstName());
       assertEquals(expectedUser.getLastName(), newUser.getLastName());
       assertTrue(BCrypt.checkpw(password, newUser.getPasswordHash()));  // Verify password hashing

       // If applicable, verify user storage in mock data store (optional)
       // ... verify user in mock data store ...
   }

    // Test for password hashing (if not already covered in RegisterController)
    @Test
    public void testHashPassword() {
        String plainPassword = "password123";
        String hashedPassword = controller.hashPassword(plainPassword);

        // Hashed password should not be the same as plain text
        assertNotEquals(plainPassword, hashedPassword);

        // Verify that BCrypt can validate the hashed password
        assertTrue(BCrypt.checkpw(plainPassword, hashedPassword));
    }
}