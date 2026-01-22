package fr.wieczorek.chess;

public class Chess {

    public static void main(String[] args) {

        Echiquier echiquier = new Echiquier();
        echiquier.instancierEchiquier(Echiquier.BASIC_DISPOSITION);
        JChessFenetre vueFenetre = new JChessFenetre(echiquier);
        Controleur controleur = new Controleur(vueFenetre,echiquier);

    }

}
