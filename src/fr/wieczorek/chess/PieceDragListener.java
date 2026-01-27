package fr.wieczorek.chess;

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
            controleur.getVue().getVueEchiquier().resetCasesMouvementsPossible(
                    this.casePieceRecuperee.getCaseAffichee().getPiece().getMouvementPattern());

            if(!caseCliquee.equals(this.casePieceRecuperee)){
                controleur.getEchiquier().makeMove(this.casePieceRecuperee.getCaseAffichee(), caseCliquee.getCaseAffichee());
            }

            this.casePieceRecuperee.setEstCliquee(false);
            this.casePieceRecuperee.repaint();
            this.casePieceRecuperee = null;

        }else{
            if(!caseCliquee.getCaseAffichee().isEmpty()){
                moveEnCours = true;
                caseCliquee.setEstCliquee(true);
                this.casePieceRecuperee = caseCliquee;
                controleur.getVue().getVueEchiquier().setCasesMouvementsPossible(
                        this.casePieceRecuperee.getCaseAffichee().getPiece().getMouvementPattern());
            }
        }
        caseCliquee.repaint();
    }
}
