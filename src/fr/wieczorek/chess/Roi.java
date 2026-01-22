package fr.wieczorek.chess;

public class Roi extends Piece {

    public Roi(int haut, int larg, boolean isWhite){
        super(haut,larg,isWhite);
    }

    @Override
    public String getPhotoPiece(){
        StringBuilder sb = new StringBuilder();
        sb.append("res/");
        if(isWhite){
            sb.append("roi-blanc.png");
        }else{
            sb.append("roi-noir.png");
        }
        return sb.toString();
    }

}
