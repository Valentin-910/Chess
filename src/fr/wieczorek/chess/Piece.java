package fr.wieczorek.chess;

public abstract class Piece {

    protected int hauteur;
    protected int largeur;
    protected boolean isWhite;

    public Piece(int haut, int larg, boolean isWhite){
        this.hauteur = haut;
        this.largeur = larg;
        this.isWhite = isWhite;
    }

    public String getPhotoPiece() {
        return null;
    }

}
