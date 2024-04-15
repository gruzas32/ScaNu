package org.openjfx.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneChanger {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public SceneChanger(Stage stage) {
        this.stage = stage;
    }


    public void OpenScene(String fxml, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml)); // Use getClass() to get the correct resource location
            root = fxmlLoader.load();
            scene = new Scene(root);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();


        } catch (Exception e) {
            System.out.println("Klaida - negalime atidaryti scenos!");
        }
    }


}
