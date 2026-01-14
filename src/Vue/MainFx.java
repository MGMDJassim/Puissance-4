package Vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFx extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader root = new FXMLLoader(getClass().getResource("fenetre.fxml"));
        Parent loader = root.load();

        stage.setTitle("puissance 4");
        stage.setScene(new Scene(loader));
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
