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


    @Override
    public boolean[][] getMouvementPattern(){
        boolean[][] res = new boolean[8][8];

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                res[x][y] = false;
            }
        }

        int xRoi = this.getX();
        int yRoi = this.getY();

        if(xRoi == 0){ //collé en haut
            res[xRoi+1][yRoi] = true;
            if(yRoi == 0){ // collé à gauche
                res[xRoi+1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
            }else if(yRoi == 7){ // collé à droite
                res[xRoi+1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
            }else{
                res[xRoi+1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
                res[xRoi+1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
            }

        }else if(xRoi == 7){ // collé en bas
            res[xRoi-1][yRoi] = true;
            if(yRoi == 0){ // collé à gauche
                res[xRoi-1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
            }else if(yRoi == 7){ // collé à droite
                res[xRoi-1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
            }else{
                res[xRoi-1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
                res[xRoi-1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
            }

        }else{ //collé ni en bas, ni à gauche
            res[xRoi+1][yRoi] = true;
            res[xRoi-1][yRoi] = true;
            if(yRoi == 0){ // collé à gauche
                res[xRoi-1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
                res[xRoi+1][yRoi+1] = true;
            }else if(yRoi == 7){ // collé à droite
                res[xRoi+1][yRoi-1] = true;
                res[xRoi-1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
            }else{
                res[xRoi-1][yRoi+1] = true;
                res[xRoi][yRoi+1] = true;
                res[xRoi-1][yRoi-1] = true;
                res[xRoi][yRoi-1] = true;
                res[xRoi+1][yRoi+1] = true;
                res[xRoi+1][yRoi-1] = true;
            }
        }

        return res;
    }
}
