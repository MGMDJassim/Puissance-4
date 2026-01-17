package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerDemarrage {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void btnNP(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/Vue/modeJeu.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to page2");

    }

    @FXML
    public void btnCP(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("plateau.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to page1");
    }

}

