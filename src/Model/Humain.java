package Model;
import java.util.Scanner;

public class Humain extends Player {


    public Humain(Token token) {
        super(token);
    }

    @Override
    public int choixCol(Plateau plateau) {
        return -1;
    }

}
