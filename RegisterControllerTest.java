package org.openjfx.demo;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import entity.LoggedUser;
import entity.Users;
import org.hibernate.SessionFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {

    GenericDAO<Users> usersDAO;

    @Mock
    private SessionFactory sessionFactory;

    @InjectMocks
    private RegisterController registerController;

    public RegisterControllerTest() {
        usersDAO = new GenericDAO<>(sessionFactory);
    }

    @Test
    public void registerUser_withValidData_createsUserAndLoggedUser() {
        // Arrange
        String username = "testuser";
        String password = "password123";
        String firstName = "John";
        String lastName = "Doe";

        // Act
        // Assert
        Users createdUser = new Users(username, firstName, lastName, registerController.hashPassword(password));
        usersDAO.create(createdUser);
        verify(usersDAO).create(createdUser);
        LoggedUser loggedUser = new LoggedUser(createdUser.getUserId(), false);
        // Optional: Verify logged user creation if applicable

        // You can add further assertions for specific user properties
    }

    /*@Test
    public void registerUser_withEmptyFields_doesNotCreateUser() {
        // Arrange
        String username = "";
        String password = "";
        String firstName = "";
        String lastName = "";

        // Act
        registerController.RegisterUser(username, password, firstName, lastName);

        // Assert
        verify(sessionFactory, never()).wait(any()); // Verify no user creation
    }
*/
    // Add more tests for different scenarios (invalid data, edge cases)
}