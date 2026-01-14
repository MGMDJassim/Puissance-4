package Model;

public class Token {

    private String symbol;

    public Token(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Token other = (Token) obj;
        return symbol.equals(other.symbol);
    }
}
