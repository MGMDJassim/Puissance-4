import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("Clique moi");
        button.setOnAction(e -> System.out.println("Bouton cliqué !"));

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("JavaFX sans FXML");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
