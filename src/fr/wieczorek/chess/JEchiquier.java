package fr.wieczorek.chess;

import javax.swing.*;
import java.awt.*;

public class JEchiquier extends JPanel {

    private JCase[][] tabCases;

    public JEchiquier(Echiquier echiquierModel){
        this.setLayout(new GridLayout(8,8));

        Case[][] tableauEchiquier = echiquierModel.getTableauCases();
        this.tabCases = new JCase[8][8];

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
}
