package org.openjfx.demo;

import com.mysql.cj.log.Log;
import entity.LoggedUser;
import entity.Users;
import jakarta.persistence.EntityManagerFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class LoginController extends SceneChanger {
    public TextField login;
    private int userId;
    public PasswordField password;
    private final SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;
    private List<LoggedUser> allLoggedUsers = new ArrayList<>();


    public LoginController() {
        super(new Stage());
        sessionFactory = SessionFactoryProvider.provideSessionFactory();
    }

    public LoginController(Stage stage, SessionFactory sessionFactory) {
        super(stage);
        this.sessionFactory = sessionFactory;
    }

    public void UserLogin() {
       String login = this.login.getText();
        String password = this.password.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacinis langas");
        alert.setHeaderText(null);
        GenericDAO<Users> usersDAO = new GenericDAO<>(sessionFactory);
        GenericDAO<LoggedUser> loggedUsersDAO = new GenericDAO<>(sessionFactory);
        Users user = usersDAO.retrieveUserByUsername(login);
        if(user == null){
            alert.setContentText("Neteisingas prisijungimo vardas arba slaptažodis!");
            alert.showAndWait();
        }
        if(this.login.getText().equals("") || this.password.getText().equals("")){
            alert.setContentText("Prašome užpildyti visus laukus");
            alert.showAndWait();
        }
        else if(login.equals(user.getUsername())&& checkPassword(password, user.getPasswordHash())){
                allLoggedUsers = loggedUsersDAO.retrieveAllLoggedUsers();
                for (LoggedUser logged : allLoggedUsers) {
                    if (user.getUserId() == logged.getUserId()) {
                        logged.setLogged(true);
                        loggedUsersDAO.update(logged);
                    }
                }
            Stage currentStage = (Stage) this.login.getScene().getWindow();
            currentStage.close();
            OpenScene("shop.fxml", "ScaNu");
        }

    }
    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    public void UserRegister() {
        Stage currentStage = (Stage) login.getScene().getWindow();
        currentStage.close();
        OpenScene("register.fxml", "Registracija");
    }

    public int returnUserId(){
        return userId;
    }


}
