package Model;
public class Plateau {
    private int columns = 8;
    private int rows = 9;
    private Player[][] tableau;

    public Plateau() {
        createTableau();
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    private void createTableau() {
        tableau = new Player[rows][columns];
        resetTableau();
    }

    private void resetTableau() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tableau[i][j] = null;
            }
        }
    }

    public void printTableau() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tableau[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + tableau[i][j].getCouleur().toString().charAt(0) + "]");
                }
            }
            System.out.println();
        }
    }

    public boolean colPleine(){
        boolean plein = false;
        for(int j = 0; j< columns; j++){
            if(tableau[0][j] != null){
                plein = true;
            }
        }
        return plein;
    }

    public boolean grillePleine(){
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< columns; j++){
                if(tableau[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean choixValide(int col){
        if(col < 0 || col >= columns){
            return false;
        }

        return true;
    }

    public boolean ajouterJeton(Player player){
        int c = player.choixcolonne();
        if(!choixValide(c)){
            return false;
        }

        if(colPleine()){
            return false;
        }

        for(int i = rows - 1; i >= 0; i--){
            if(tableau[i][c] == null){
                tableau[i][c] = player;
                return true;
            }
        }

        return false;
    }

}
