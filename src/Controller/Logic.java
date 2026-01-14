package Controller;

import Model.Plateau;
import Model.Player;
import Model.Token;

public class Logic {

        Plateau pl;
        Player p1, p2, currentPlayer;

        public Logic(Plateau pl, Player p1, Player p2, Player currentPlayer){
            this.pl = pl;
            this.p1 = p1;
            this.p2 = p2;
            this.currentPlayer = currentPlayer;
        }

        public Player getCurrentPlayer(){
            return currentPlayer;
        }

        public Plateau getPl(){
            return pl;
        }

        public void switchPlayer (){
            if(currentPlayer == p1){
                currentPlayer = p2;
            }
            else{
                currentPlayer = p1;
            }
        }

        public void placeToken (int col){
            Token t = currentPlayer.getToken();
            if(pl.estValid(col)){
                int row = pl.premierCaseVide(col);
                pl.setToken(row, col, t);
            }
            else{
                System.out.print("Il n'est pas valide!");
            }
        }




}
