package IHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import snoke.*;

public class Fenetre extends JFrame{
    
    private Container c ;
    public Snoke j;
    private JLabel score;
    
    public Fenetre() throws InterruptedException {
        super("Snoke");
        this.c = this.getContentPane();
        this.setBounds(0,0,600,600);
        this.j = new Snoke((this.getWidth()-50)/20,(this.getHeight()-120)/20);
        this.j.nouvellePartie();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initMenu();
        this.setVisible(true);
        this.actualiseJeu();
    }
    
    public void initOptions(){
        this.c.removeAll();
        JPanel pan = new PannelOptions(this);
        this.c.add(pan);
        this.c.validate();
    }
    
    public void initMenu(){
        this.c.removeAll();
        JPanel pan = new PannelMenu(this);
        this.c.add(pan);
        this.c.validate();
    }
    
    public void initPanJeu() throws InterruptedException{
        this.c.removeAll();
        if(this.j.estEnPause())
            j.unPause();
        KeyLis lis = new KeyLis();
        this.addKeyListener(lis);
        this.c.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        score = new JLabel("Score : "+this.j.getScore());
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font(null,0,20));
        score.setForeground(Color.WHITE);
        p.setBackground(Color.GRAY);
        p.add(score,BorderLayout.NORTH);
        p.add(new PannelAffichageJeu(this),BorderLayout.CENTER);
        this.c.add(p);
        this.c.validate();
        this.requestFocus();
    }
       
    public void  actualiseJeu() throws InterruptedException{
        while(j.estEnPause()&& !j.aPerdu()){
            while(!j.aPerdu()&&!j.estEnPause()){
                this.j.metAJour();
                this.repaint();
            }
        }
        this.initMenu();
        this.j.nouvellePartie();
        this.actualiseJeu();
    }
  
    
    /*  KEYLISTENER  */
    
    public class KeyLis implements KeyListener{
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP)
                j.haut();
            else if(e.getKeyCode() == KeyEvent.VK_DOWN)
                j.bas();
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                j.droite();
            else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                j.gauche(); 
            else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                Fenetre.this.initMenu();
                j.pause();
            }
            score.setText("Score : "+j.getScore());
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }
}
