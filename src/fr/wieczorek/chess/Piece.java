package fr.wieczorek.chess;

public abstract class Piece {

    protected int x;
    protected int y;
    protected boolean isWhite;

    public Piece(int x, int y, boolean isWhite){
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

}
