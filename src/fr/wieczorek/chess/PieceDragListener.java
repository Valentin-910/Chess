package fr.wieczorek.chess;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceDragListener extends MouseAdapter {

    private boolean moveEnCours;

    private Controleur controleur;

    private JCase casePieceRecuperee;

    public PieceDragListener(Controleur c){
        this.controleur = c;
        this.moveEnCours = false;
        this.casePieceRecuperee = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JCase caseCliquee = (JCase) e.getSource();
        if(moveEnCours){
            moveEnCours = false;
            if(!caseCliquee.equals(this.casePieceRecuperee)){
                caseCliquee.getCaseAffichee().setPiece(this.casePieceRecuperee.getCaseAffichee().getPiece());
                this.casePieceRecuperee.getCaseAffichee().setPiece(null);
            }else{
                //rien...
            }
            this.casePieceRecuperee.setEstCliquee(false);
            this.casePieceRecuperee.repaint();
            this.casePieceRecuperee = null;

        }else{
            if(!caseCliquee.getCaseAffichee().isEmpty()){
                moveEnCours = true;
                caseCliquee.setEstCliquee(true);
                this.casePieceRecuperee = caseCliquee;
            }
        }
        caseCliquee.repaint();
    }
}
