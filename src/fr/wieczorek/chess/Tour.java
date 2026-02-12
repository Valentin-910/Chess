package fr.wieczorek.chess;

public class Tour extends Piece {

    public Tour(int haut, int larg, boolean isWhite) {
        super(haut, larg, isWhite);
    }

    @Override
    public boolean[][] getMouvementPattern() {
        boolean[][] resultat = new boolean[8][8];

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                resultat[x][y] = false;
            }
        }

        for(int caseAccessible = 0; caseAccessible < 8; caseAccessible++){
            resultat[this.getX()][caseAccessible] = true;
            resultat[caseAccessible][this.getY()] = true;
        }

        resultat[this.getX()][this.getY()] = false;

        return resultat;
    }

    @Override
    public String getPhotoPiece() {
        StringBuilder sb = new StringBuilder();
        sb.append("res/");
        if(isWhite()){
            sb.append("tour-blanc.png");
        }else{
            sb.append("tour-noir.png");
        }
        return sb.toString();
    }
}
