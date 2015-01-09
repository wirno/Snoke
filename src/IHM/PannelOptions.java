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
    private JButton hard,easy,medium,retour;
    
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
        hard = new JButton("HARD");
        hard.addActionListener(l);
        hard.setPreferredSize(new Dimension(100,50));
        hard.setBackground(Color.DARK_GRAY);
        hard.setForeground(Color.WHITE);
        easy = new JButton("EASY");
        easy.addActionListener(l);
        easy.setPreferredSize(new Dimension(100,50));
        easy.setBackground(Color.DARK_GRAY);
        easy.setForeground(Color.WHITE);
        medium = new JButton("MEDIUM");
        medium.addActionListener(l);
        medium.setPreferredSize(new Dimension(100,50));
        medium.setBackground(Color.DARK_GRAY);
        medium.setForeground(Color.WHITE);
        pan.add(easy);
        pan.add(medium);
        pan.add(hard);
        return pan;
    }
    
    public JPanel pannelTrois(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        Lis l = new Lis();
        retour = new JButton("RETOUR");
        retour.addActionListener(l);
        retour.setPreferredSize(new Dimension(150,50));
        retour.setBackground(Color.DARK_GRAY);
        retour.setForeground(Color.WHITE);
        pan.add(retour);
        return pan;
    }
    
    public class Lis implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == hard){
                PannelOptions.this.fen.j.setDifficulte(Jeu.DIFFICILE);
            }
            if(e.getSource() == easy){
                PannelOptions.this.fen.j.setDifficulte(Jeu.FACILE);
            }
            if(e.getSource() == medium){
                PannelOptions.this.fen.j.setDifficulte(Jeu.MOYEN);
            }
            if(e.getSource() == retour){
                PannelOptions.this.fen.initMenu();
            }
        }
        
    }
}
