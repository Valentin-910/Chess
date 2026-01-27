package fr.wieczorek.chess;

import javax.swing.*;
import java.awt.*;

public class JCase extends JPanel {

    private Case caseAffichee;

    private boolean estCliquee;

    private boolean afficherMovePossible;

    public JCase(Case c){
        super();
        this.caseAffichee = c;
    }

    public void setAfficherMovePossible(boolean val){ this.afficherMovePossible = val; }

    public Case getCaseAffichee(){
        return this.caseAffichee;
    }

    public Point getPosition(){
        return this.caseAffichee.getPosition();
    }

    public void setEstCliquee(boolean val){
        this.estCliquee = val;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics pinceau = g.create();

        Point positionCase = caseAffichee.getPosition();
        if(estCliquee){
            this.setBackground(new Color(57, 227, 86));
        }else if(((positionCase.getX() + positionCase.getY()) % 2) == 0){
            this.setBackground(new Color(138, 72, 0));
        }else {
            this.setBackground(new Color(207, 146, 83));
        }


        if(caseAffichee.getPiece() != null) {
            ImageIcon imageIcon = new ImageIcon(caseAffichee.getPiece().getPhotoPiece());
            Image image = imageIcon.getImage();

            // Taille de la bordure
            int bordure = 5;

            // Dimensions disponibles (panel moins bordures)
            int largeurDispo = this.getWidth() - (2 * bordure);
            int hauteurDispo = this.getHeight() - (2 * bordure);

            // Dimensions originales de l'image
            int largeurImg = image.getWidth(this);
            int hauteurImg = image.getHeight(this);

            // Calculer le ratio pour conserver les proportions
            double ratioImage = (double) largeurImg / hauteurImg;
            double ratioPanel = (double) largeurDispo / hauteurDispo;

            int nouvelleLargeur, nouvelleHauteur;

            if (ratioImage > ratioPanel) {
                // L'image est plus large proportionnellement
                nouvelleLargeur = largeurDispo;
                nouvelleHauteur = (int) (largeurDispo / ratioImage);
            } else {
                // L'image est plus haute proportionnellement
                nouvelleHauteur = hauteurDispo;
                nouvelleLargeur = (int) (hauteurDispo * ratioImage);
            }

            // Centrer l'image
            int x = (this.getWidth() - nouvelleLargeur) / 2;
            int y = (this.getHeight() - nouvelleHauteur) / 2;

            // Dessiner l'image redimensionnée et centrée
            g.drawImage(image, x, y, nouvelleLargeur, nouvelleHauteur, this);
        }

        if(afficherMovePossible){
            pinceau.setColor(new Color(83, 207, 188));
            pinceau.fillOval((this.getWidth()/2) - 20, (this.getHeight()/2) - 20, 40, 40);
        }
    }


    public boolean equals(JCase c) {
        return this.caseAffichee.equals(c.getCaseAffichee());
    }
}
