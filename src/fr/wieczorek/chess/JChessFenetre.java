package fr.wieczorek.chess;

import javax.swing.*;

public class JChessFenetre extends JFrame {

    public JChessFenetre(Echiquier echiquierModel){
        super("Chess");
        this.setSize(700,700);
        this.setDefaultCloseOperation(JChessFenetre.EXIT_ON_CLOSE);

        JEchiquier echiquierVue = new JEchiquier(echiquierModel);

        this.add(echiquierVue);

        this.setVisible(true);
    }

}
