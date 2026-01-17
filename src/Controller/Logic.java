package Controller;

import Model.*;

public class Logic {

    private ModeJeu mode;
    private Plateau pl;
    private Player p1, p2, currentPlayer, gagnant;

    public Logic() {
        this.mode = ManagementJeu.getMode();
        this.pl = new Plateau();
        initPlayer();
    }

    private void initPlayer() {
        switch (mode) {
            case PvP:
                p1 = new Humain(Token.RED);
                p2 = new Humain(Token.YELLOW);
                break;

            case JvIA:
                p1 = new Humain(Token.RED);
                p2 = new IA(Token.YELLOW);
                break;

            case IA:
                p1 = new IA(Token.RED);
                p2 = new IA(Token.YELLOW);
                break;

            default:
                throw new IllegalStateException("Mode inconnu : " + mode);
        }

        currentPlayer = p1;
    }

    public boolean jouerCoup(int col) {
        if (gagnant != null) return false;
        if (!estValid(col)) return false;
        if (colPleine(col)) return false;

        int row = premiereCaseVide(col);
        if (row == -1) return false;

        pl.setToken(row, col, currentPlayer.getToken());

        if (checkWinner(row, col)) {
            gagnant = currentPlayer;
            return true;
        }

        changerJoueur();
        return true;
    }

    private void changerJoueur() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }

    public Player getJoueurCourant() {
        return currentPlayer;
    }

    public Player getGagnant() {
        return gagnant;
    }

    public boolean colPleine(int col) {
        return pl.getCell(0, col) != null;
    }

    public int premiereCaseVide(int col) {
        for (int row = pl.getRows() - 1; row >= 0; row--) {
            if (pl.getCell(row, col) == null) {
                return row;
            }
        }
        return -1;
    }

    public boolean estValid(int col) {
        return col >= 0 && col <= pl.getColumns();
    }

    public boolean grillePleine() {
        for (int c = 0; c < pl.getColumns(); c++) {
            if (pl.getCell(0, c) == null) return false;
        }
        return true;
    }

    private boolean checkWinner(int row, int col) {
        Token t = pl.getCell(row, col);
        if (t == null) return false;

        return checkDirection(row, col, 0, 1, t) ||   // Horizontal
                checkDirection(row, col, 1, 0, t) ||   // Vertical
                checkDirection(row, col, 1, 1, t) ||   // Diagonale /
                checkDirection(row, col, 1, -1, t);    // Diagonale \
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol, Token t) {
        int count = 1;

        // Avant
        for (int i = 1; i < 4; i++) {
            int r = row + dRow * i;
            int c = col + dCol * i;
            if (!isInside(r, c) || pl.getCell(r, c) != t) break;
            count++;
        }

        // Arrière
        for (int i = 1; i < 4; i++) {
            int r = row - dRow * i;
            int c = col - dCol * i;
            if (!isInside(r, c) || pl.getCell(r, c) != t) break;
            count++;
        }

        return count >= 4;
    }

    private boolean isInside(int r, int c) {
        return r >= 0 && r < pl.getRows() && c >= 0 && c < pl.getColumns();
    }

    public void resetPartie() {
        gagnant = null;
        pl.resetTableau();
        initPlayer();
    }
}
