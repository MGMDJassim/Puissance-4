package Model;
public class Plateau {
    private final int NUMBER_COLUMNS = 8;
    private final int NUMBER_ROWS = 9;
    private final Token[][] plateau;

    public Plateau() {
        plateau = new Token[NUMBER_ROWS][NUMBER_COLUMNS];
    }

    public void setToken(int row, int col, Token token){
        plateau[row][col] = token;
    }

    public Token getCell(int col, int row){
        if(row<0 || row > NUMBER_ROWS || col <0 || col > NUMBER_COLUMNS){
            return null;
        }
        return plateau[row][col];
    }

    public int getColumns (){
        return NUMBER_COLUMNS;
    }

    public int getRows () {return NUMBER_ROWS;}

    private void resetTableau() {
        for (int i = 0; i < NUMBER_ROWS; i++) {
            for (int j = 0; j < NUMBER_COLUMNS; j++) {
                plateau[i][j] = null;
            }
        }
    }

    public boolean colPleine(int col){
        return plateau[0][col] != null;
    }

    public boolean grillePleine(){
        for(int i = 0; i< NUMBER_ROWS; i++){
            for(int j = 0; j< NUMBER_COLUMNS; j++){
                if(plateau[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estValid(int col){
        return col <= NUMBER_COLUMNS && col >= 0;
    }

    public int premierCaseVide(int col){
        int row = getRows() -1;

        while(row >=0){
            if(plateau[row][col] != null){
                row--;
            }
            else if(plateau[row][col] == null) {
                break;
            }
        }
        return row;
    }

    public boolean checkWinner() {
        for (int row = 0; row < NUMBER_ROWS; row++) {
            for (int col = 0; col < NUMBER_COLUMNS; col++) {

                Token t = plateau[row][col];
                if (t == null) continue;

                if (checkDirection(row, col, 0, 1) ||
                        checkDirection(row, col, 1, 0) ||
                        checkDirection(row, col, 1, 1) ||
                        checkDirection(row, col, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean checkDirection(int row, int col, int dRow, int dCol){
        Token t = plateau[row][col];
        for(int i = 1; i < 4; i++){
            int r = row + dRow *i;
            int c = col + dCol *i;

            if(r <0 || r>= NUMBER_ROWS || c < 0 || !plateau[r][c].equals(t) || plateau[r][c] == null){
                return false;
            }
        }
        return true;
    }
}
