package fr.wieczorek.chess;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Echiquier {

    private Case[][] tableauCases;
    private Queue<Piece> filePiecesBlanches;
    private Queue<Piece> filePiecesNoires;

    public static final int BASIC_DISPOSITION = 0;

    public Echiquier(){
        this.tableauCases = new Case[8][8];
        this.filePiecesNoires = new LinkedList<>();
        this.filePiecesBlanches = new LinkedList<>();

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                this.tableauCases[x][y] = new Case(x,y);
            }
        }
    }

    public void instancierEchiquier(int disposition){
        if(disposition == BASIC_DISPOSITION) {
            //pièces blanches
            Roi roiBlanc = new Roi(7,4,true);
            this.tableauCases[7][4].setPiece(roiBlanc);
            this.filePiecesBlanches.add(roiBlanc);

            //pièces noires
            Roi roiNoir = new Roi(0,4,false);
            this.tableauCases[0][4].setPiece(roiNoir);
            this.filePiecesNoires.add(roiNoir);
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


    public void makeMove(Case depart, Case arrivee){
        Piece pieceToMove = depart.getPiece();
        boolean[][] moves = getMouvementsPossibles(pieceToMove);

        int xArrivee = arrivee.getX();
        int yArrivee = arrivee.getY();

        if(moves[xArrivee][yArrivee]){
            pieceToMove.setX(xArrivee);
            pieceToMove.setY(yArrivee);

            arrivee.setPiece(pieceToMove);
            depart.setPiece(null);
        }
    }

    public boolean[][] getMouvementsPossibles(Piece pieceToMove){
        return getMouvementsPossibles(pieceToMove, true);
    }

    public boolean[][] getMouvementsPossibles(Piece pieceToMove, boolean isRoi){
        boolean[][] moves = pieceToMove.getMouvementPattern();

        if(pieceToMove.isWhite()){
            for(Piece p : filePiecesBlanches){
                moves[p.getX()][p.getY()] = false;
            }
            for(Piece p : filePiecesNoires){
                if(isRoi && pieceToMove.toString().equals("white-king")) {
                    boolean[][] movesPiece = this.getMouvementsPossibles(p, false);
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (movesPiece[x][y]){
                                moves[x][y] = false;
                            }
                        }
                    }
                }
            }
        }else{
            for(Piece p : filePiecesNoires){
                moves[p.getX()][p.getY()] = false;
            }
            for(Piece p : filePiecesBlanches){
                if(isRoi && pieceToMove.toString().equals("black-king")) {
                    boolean[][] movesPiece = this.getMouvementsPossibles(p, false);
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (movesPiece[x][y]){
                                moves[x][y] = false;
                            }
                        }
                    }
                }
            }
        }

        return moves;
    }
}
