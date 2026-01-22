package fr.wieczorek.chess;

import javax.swing.*;

public class JChessFenetre extends JFrame {

    private JEchiquier echiquierVue;

    public JChessFenetre(Echiquier echiquierModel){
        super("Chess");
        this.setSize(700,700);
        this.setDefaultCloseOperation(JChessFenetre.EXIT_ON_CLOSE);

        this.echiquierVue = new JEchiquier(echiquierModel);

        this.add(this.echiquierVue);

        this.setVisible(true);
    }

    public JEchiquier getVueEchiquier(){
        return this.echiquierVue;
    }

}
