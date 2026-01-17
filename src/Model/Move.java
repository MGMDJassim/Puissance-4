package Model;

public class Move {

    private final int row;
    private final int col;
    private final Token token;

    public Move(int row, int col, Token token) {
        this.row = row;
        this.col = col;
        this.token = token;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Token getToken() {
        return token;
    }
}
