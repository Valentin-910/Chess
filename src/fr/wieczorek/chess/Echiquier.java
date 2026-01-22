package fr.wieczorek.chess;

import java.awt.*;

public class Echiquier {

    private Case[][] tableauCases;

    public static final int BASIC_DISPOSITION = 0;

    public Echiquier(){
        this.tableauCases = new Case[8][8];

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                this.tableauCases[x][y] = new Case(x,y);
            }
        }
    }

    public void instancierEchiquier(int disposition){
        if(disposition == BASIC_DISPOSITION) {
            //pièces blanches
            this.tableauCases[7][4].setPiece(new Roi(7,4,true));

            //pièces noires
            this.tableauCases[0][4].setPiece(new Roi(0,4,false));
        }else{
            throw new IllegalArgumentException("Disposition des pièces inconnue");
        }
    }

    public Case[][] getTableauCases() {
        return tableauCases;
    }

    public Case getCase(int x, int y){
        if(x > 7 || y > 7){
            throw new ArrayIndexOutOfBoundsException("Received x = "+ x + " and y = "+ y +" while x and y cannot surpass 7");
        }

        return this.tableauCases[x][y];
    }

    public Case getCase(Point puntos){
        if(puntos.getX() > 7 || puntos.getY() > 7){
            throw new ArrayIndexOutOfBoundsException("Received x = "+ puntos.getX() + " and y = "+ puntos.getY() +" while x and y cannot surpass 7");
        }

        return this.tableauCases[(int) puntos.getX()][(int) puntos.getY()];
    }
}
