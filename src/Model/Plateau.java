package Model;

public class Plateau {

    private final int NUMBER_ROWS = 8;     // 8 lignes
    private final int NUMBER_COLUMNS = 9;  // 9 colonnes

    private final Token[][] plateau;

    public Plateau() {
        plateau = new Token[NUMBER_ROWS][NUMBER_COLUMNS];
    }

    public void setToken(int row, int col, Token token) {
        plateau[row][col] = token;
    }

    public Token getCell(int row, int col) {
        if (!isInside(row, col)) {
            return null;
        }
        return plateau[row][col];
    }

    public int getColumns() {
        return NUMBER_COLUMNS;
    }

    public int getRows() {
        return NUMBER_ROWS;
    }

    public void resetTableau() {
        for (int i = 0; i < NUMBER_ROWS; i++) {
            for (int j = 0; j < NUMBER_COLUMNS; j++) {
                plateau[i][j] = null;
            }
        }
    }

    private boolean isInside(int row, int col) {
        return row >= 0 && row < NUMBER_ROWS && col >= 0 && col < NUMBER_COLUMNS;
    }
}
