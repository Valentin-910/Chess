package fr.wieczorek.chess;

import javax.swing.*;
import java.awt.*;

public class JEchiquier extends JPanel {

    private JCase[][] tabCases;

    private boolean[][] lastMouvementsPossibles;

    public JEchiquier(Echiquier echiquierModel){
        this.setLayout(new GridLayout(8,8));

        Case[][] tableauEchiquier = echiquierModel.getTableauCases();
        this.tabCases = new JCase[8][8];
        this.lastMouvementsPossibles = new boolean[8][8];

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                this.tabCases[x][y] = new JCase(tableauEchiquier[x][y]);
                this.add(this.tabCases[x][y]);
            }
        }
    }

    public JCase[][] getTabCases() {
        return this.tabCases;
    }

    public void setCasesMouvementsPossible(boolean[][] moves){
        this.lastMouvementsPossibles = moves;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(moves[x][y]){
                    this.tabCases[x][y].setAfficherMovePossible(true);
                    this.tabCases[x][y].repaint();
                }
            }
        }
    }

    public void resetCasesMouvementsPossible(boolean[][] moves){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(moves[x][y]){
                    this.tabCases[x][y].setAfficherMovePossible(false);
                    this.tabCases[x][y].repaint();
                }
            }
        }
    }
}
