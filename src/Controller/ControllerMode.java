package Controller;

import java.io.IOException;
import java.util.Objects;

import Model.ManagementJeu;
import Model.ModeJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerMode {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void chargementMode(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Vue/plateau.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }


    public void choix(ActionEvent event) throws Exception{
        Button cliked = (Button) event.getSource();
        String text = cliked.getText();
        ModeJeu mode = ModeJeu.valueOf(text);
        ManagementJeu.setMode(mode);
        chargementMode(event);
        System.out.println(text);
    }

    public void btnRetour(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Vue/demarrage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

}
