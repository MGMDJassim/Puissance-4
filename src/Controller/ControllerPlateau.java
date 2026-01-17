package Controller;

import Model.Plateau;
import Model.Token;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPlateau implements Initializable {

    @FXML
    private GridPane plateau;
    @FXML
    private BorderPane root;
    private Plateau pl;
    private Pane[][] cells;

    private Logic logic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pl= new Plateau();
        logic = new Logic();
        cells = new Pane[pl.getRows()][pl.getColumns()];
        initUI();
        generateBoard();
        enableColumnClicks();
    }

    private void initUI() {
        plateau.setAlignment(Pos.CENTER);
    }

    private void generateBoard() {
        for (int row = 0; row < pl.getRows(); row++) {
            for (int col = 0; col < pl.getColumns(); col++) {
                Pane cell = new Pane();
                cell.getStyleClass().add("cell");
                plateau.add(cell, col, row);
                cells[row][col] = cell;
            }
        }
    }

    private void enableColumnClicks() {
        plateau.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            Node clicked = event.getPickResult().getIntersectedNode();
            if (clicked == plateau) return;
            Integer col = GridPane.getColumnIndex(clicked);
            if (col == null) return;
            Token tokenQuiJoue = logic.getJoueurCourant().getToken(); // IMPORTANT
            int row = logic.premiereCaseVide(col); // AVANT jouerCoup
            boolean success = logic.jouerCoup(col);
            if (success) {
                updateCell(row, col, tokenQuiJoue); // PAS logic.getJoueurCourant()
            }
            if (logic.getGagnant() != null) {
                System.out.println("Victoire de " + logic.getGagnant().getToken());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Joueur " + logic.getJoueurCourant().getToken() + " a gangé");
                alert.show();
            }
        });
    }



    private void updateCell(int row, int col, Token token) {
        Pane cell = cells[row][col];
        if (token == Token.RED) {
            cell.getStyleClass().add("p1");
        } else {
            cell.getStyleClass().add("p2");
        }
    }
}
