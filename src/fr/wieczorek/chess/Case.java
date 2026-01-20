package fr.wieczorek.chess;

import java.awt.*;

public class Case {

    private Piece piece;
    private int x;
    private int y;

    public Case(int x, int y){
        this.piece = null;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece p){
        this.piece = p;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public Point getPosition(){
        return new Point(x,y);
    }



}
