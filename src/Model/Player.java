package Model;
public abstract class Player {
    private String couleur;

    public Player(String couleur){
        this.couleur = couleur;
    }

    public String getCouleur(){
        return couleur;
    }

    public abstract int choixcolonne();
}
