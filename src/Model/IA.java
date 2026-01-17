package Model;

public class IA extends Player{
    public IA(Token token) {
        super(token);
    }

    @Override
    public int choixCol(Plateau plateau) {
        return 7;
    }
}
