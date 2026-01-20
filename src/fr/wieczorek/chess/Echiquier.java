package fr.wieczorek.chess;

public class Echiquier {

    private Case[][] tableauCases;

    public static final int BASIC_DISPOSITION = 0;

    public Echiquier(){
        this.tableauCases = new Case[8][8];

        for(int x = 1; x < 9; x++){
            for(int y = 1; y < 9; y++){
                this.tableauCases[x-1][y-1] = new Case(x,y);
            }
        }
    }

    public void instancierEchiquier(int disposition){
        if(disposition == BASIC_DISPOSITION) {
            //pièces blanches
            this.tableauCases[4][7].setPiece(new Roi(4,7,true));

            //pièces noires
            this.tableauCases[4][7].setPiece(new Roi(4,0,false));
        }else{
            throw new IllegalArgumentException("Disposition des pièces inconnue");
        }
    }

    public Case[][] getTableauCases() {
        return tableauCases;
    }
}
