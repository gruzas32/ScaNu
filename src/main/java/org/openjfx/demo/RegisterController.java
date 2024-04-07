package org.openjfx.demo;

import entity.LoggedUser;
import entity.Users;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Date;

public class RegisterController extends SceneChanger {

    public PasswordField passwordField;
    public TextField usernameField;
    public  TextField firstNameField;
    public TextField lastNameField;

 public int userId;

    private final SessionFactory sessionFactory;


    public RegisterController(Stage stage, SessionFactory sessionFactory) {
        super(stage);
        this.sessionFactory = sessionFactory;
    }
    public RegisterController() {
        super(new Stage());
        sessionFactory = SessionFactoryProvider.provideSessionFactory();
    }

    public void RegisterUser() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()  || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()) {
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
            return;
        }
        GenericDAO<Users> usersDAO = new GenericDAO<>(sessionFactory);
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        LoggedUser loggedUser = new LoggedUser();
        Users user = new Users();
            user.setUsername(usernameField.getText());
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());
            user.setPasswordHash(hashPassword(passwordField.getText()));
           usersDAO.create(user);
            loggedUser.setUserId(userId);
            loggedUser.setLogged(false);
            loggedUsersDAO.create(loggedUser);
            alert.setContentText("user registered");
            alert.showAndWait();
            Stage currentStage = (Stage) passwordField.getScene().getWindow();
            currentStage.close();
            OpenScene("login.fxml", "Login");
    }
    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
    public void BackToLogin() {
        Stage currentStage = (Stage) passwordField.getScene().getWindow();
        currentStage.close();
        OpenScene("login.fxml", "Login");
    }
}
