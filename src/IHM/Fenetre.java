package IHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import snoke.*;

public class Fenetre extends JFrame{
    
    private Container c ;
    public Snoke j;
    
    public Fenetre() throws InterruptedException {
        super("Snake");
        this.c = this.getContentPane();
        this.setBounds(0,0,500,500);
        this.j = new Snoke((this.getWidth()-50)/20,(this.getHeight()-100)/20);
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
        this.requestFocus();
        if(this.j.estEnPause())
            j.unPause();
        KeyLis lis = new KeyLis();
        this.addKeyListener(lis);
        this.c.setLayout(new BorderLayout());
        JPanel p = new PannelAffichageScore();
        this.c.add(p,BorderLayout.NORTH);
        this.c.add(new PannelAffichageJeu(this.j),BorderLayout.CENTER);
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
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }
}
