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
        this.setLayout(new GridLayout(3,1));
        this.add(this.pannelUn());
        this.add(this.pannelDeux());
        this.add(this.pannelTrois());       
    }
    
    public JPanel pannelUn(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        JLabel snoke = new JLabel("OPTIONS");
        snoke.setForeground(Color.WHITE);
        snoke.setFont(new Font("impact",Font.BOLD,60));
        pan.add(snoke);
        return pan;
    }
    
    public JPanel pannelDeux(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        Lis l = new Lis();
        HARD = new JButton("HARD");
        HARD.addActionListener(l);
        HARD.setPreferredSize(new Dimension(100,50));
        pan.add(HARD);
        EASY = new JButton("EASY");
        EASY.addActionListener(l);
        EASY.setPreferredSize(new Dimension(100,50));
        pan.add(EASY);
        MEDIUM = new JButton("MEDIUM");
        MEDIUM.addActionListener(l);
        MEDIUM.setPreferredSize(new Dimension(100,50));
        pan.add(MEDIUM);
        return pan;
    }
    
    public JPanel pannelTrois(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        Lis l = new Lis();
        retour = new JButton("retour");
        retour.addActionListener(l);
        retour.setPreferredSize(new Dimension(150,50));
        pan.add(retour);
        return pan;
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
