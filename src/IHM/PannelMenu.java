package IHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PannelMenu extends JPanel {
    
    public Fenetre fen;
    public JButton jouer,options;
   
    public PannelMenu(Fenetre fen){
        this.fen = fen;
        this.setLayout(new GridLayout(3,1));
        this.add(this.pannelUn());
        this.add(this.pannelDeux());
        this.add(this.pannelTrois());
    }
    
    public JPanel pannelUn(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        JLabel snoke = new JLabel("SNOKE");
        snoke.setForeground(Color.WHITE);
        snoke.setFont(new Font("impact",Font.BOLD,80));
        pan.add(snoke);
        return pan;
    }
    
    public JPanel pannelDeux(){
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2,1));
        pan.setBackground(Color.GRAY);
        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.GRAY);
        JPanel pan3 = new JPanel();
        pan3.setBackground(Color.GRAY);
        Lis l = new Lis();
        jouer = new JButton("JOUER");
        jouer.setBackground(Color.DARK_GRAY);
        jouer.setForeground(Color.WHITE);
        jouer.setPreferredSize(new Dimension(150,50));
        jouer.addActionListener(l);
        pan2.add(jouer);
        options = new JButton("OPTIONS");
        options.setBackground(Color.DARK_GRAY);
        options.setForeground(Color.WHITE);
        options.setPreferredSize(new Dimension(150,50));
        pan3.add(options);
        options.addActionListener(l);
        pan.add(pan2);
        pan.add(pan3);
        return pan;
    }
    
    public JPanel pannelTrois(){
        JPanel pan = new JPanel();
        pan.setBackground(Color.GRAY);
        return pan;
    }
    
    public class Lis implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jouer){
                try {
                    PannelMenu.this.fen.initPanJeu();
                } catch (InterruptedException ex) {}
                
            }
            if(e.getSource() == options){
               PannelMenu.this.fen.initOptions();
            }
        }
        
    }
    
}
