package Model;
import java.util.Scanner;

public class Humain extends Player{
    private static Scanner scanner = new Scanner(System.in);

    public Humain(String color) {
        super(color);
    }

    @Override
    public int choixcolonne() {
        return scanner.nextInt();
    }

}
