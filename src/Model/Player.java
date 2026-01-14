package Model;
public abstract class Player {
    private Token token;

    public Player (Token token){
        this.token = token;
    }

    public Token getToken(){
        return token;
    }

    public abstract int choixCol(Plateau plateau);

}
