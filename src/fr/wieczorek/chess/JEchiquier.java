package fr.wieczorek.chess;

import javax.swing.*;
import java.awt.*;

public class JEchiquier extends JPanel {

    public JEchiquier(Echiquier echiquierModel){
        this.setLayout(new GridLayout(8,8));

        Case[][] tableauEchiquier = echiquierModel.getTableauCases();
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                this.add(new JCase(tableauEchiquier[x][y]));
            }
        }

    }
}
