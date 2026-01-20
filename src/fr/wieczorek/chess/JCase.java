package fr.wieczorek.chess;

import javax.swing.*;
import java.awt.*;

public class JCase extends JPanel {

    private Case caseAffichee;

    public JCase(Case c){
        super();
        this.caseAffichee = c;

        Point positionCase = caseAffichee.getPosition();
        if(((positionCase.getX() + positionCase.getY()) % 2) == 0){
            this.setBackground(new Color(138, 72, 0));
        }else {
            this.setBackground(new Color(207, 146, 83));
        }
    }



}
