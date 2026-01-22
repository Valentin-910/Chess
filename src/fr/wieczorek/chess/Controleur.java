package fr.wieczorek.chess;

public class Controleur {

    private JChessFenetre vueFenetre;
    private Echiquier echiquier;

    public Controleur(JChessFenetre vueFenetre, Echiquier ech){
        this.vueFenetre = vueFenetre;
        this.echiquier = ech;

        JCase[][] tabcases = this.vueFenetre.getVueEchiquier().getTabCases();
        PieceDragListener pdl = new PieceDragListener(this);
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++){
                tabcases[x][y].addMouseListener(pdl);
            }
        }
    }

    public JChessFenetre getVue(){
        return this.vueFenetre;
    }

    public Echiquier getEchiquier(){
        return this.echiquier;
    }
}
