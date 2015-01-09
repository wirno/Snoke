/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import snoke.Jeu;
import snoke.Snoke;

/**
 *
 * @author PC
 */
public class PannelOptions extends JPanel {
    
    private Fenetre fen;
    private JButton HARD,EASY,MEDIUM,retour;
    
    public PannelOptions(Fenetre fen){
        this.fen = fen;
        this.setLayout(new GridLayout(5,1));
        this.add(new JLabel("Options"));
        Lis l = new Lis();
        HARD = new JButton("HARD");
        HARD.addActionListener(l);
        this.add(HARD);
        EASY = new JButton("EASY");
        EASY.addActionListener(l);
        this.add(EASY);
        MEDIUM = new JButton("MEDIUM");
        MEDIUM.addActionListener(l);
        this.add(MEDIUM);
        retour = new JButton("retour");
        retour.addActionListener(l);
        this.add(retour);
    }
    
    public class Lis implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == HARD){
                PannelOptions.this.fen.j.setDifficulte(Jeu.DIFFICILE);
            }
            if(e.getSource() == EASY){
                PannelOptions.this.fen.j.setDifficulte(Jeu.FACILE);
            }
            if(e.getSource() == MEDIUM){
                PannelOptions.this.fen.j.setDifficulte(Jeu.MOYEN);
            }
            if(e.getSource() == retour){
                PannelOptions.this.fen.initMenu();
            }
        }
        
    }
}
