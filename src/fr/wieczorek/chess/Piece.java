package fr.wieczorek.chess;

public abstract class Piece {

    /**
     * x est la position de la pièce en HAUTEUR, 0 étant tout en haut et 7 tout en bas
     */
    private int x;

    /**
     * y est la position de la pièce en LARGEUR, 0 étant tout à gauche et 7 tout à droite
     */
    private int y;

    /**
     * définit si la pièce est du côté des blancs ou non
     */
    private boolean isWhite;

    public Piece(int haut, int larg, boolean isWhite){
        this.x = haut;
        this.y = larg;
        this.isWhite = isWhite;
    }

    public String toString(){
        return "unknown_piece";
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int newX){
        this.x = newX;
    }

    public void setY(int newY){
        this.y = newY;
    }

    public String getPhotoPiece() {
        return null;
    }

    public boolean isWhite(){
        return this.isWhite;
    }

    public boolean[][] getMouvementPattern(){
        boolean[][] res = new boolean[8][8];
        return res;
    }

}
