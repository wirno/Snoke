package IHM;

import Element.*;
import java.awt.*;
import javax.swing.*;
import snoke.*;

public class PannelAffichageJeu extends JPanel {
    
    private Fenetre fen;
    private Jeu j;
    
    public PannelAffichageJeu(Fenetre fen){
        this.fen = fen;
        this.j = fen.j;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
            for (int y = 0; y < Snoke.tailleMapY; y++) {
                for (int x = 0; x < Snoke.tailleMapX; x++) {
                    if(j.getMap()[y][x] instanceof Snake){
                        g.setColor(Color.BLACK);
                        g.fillRect((x*20)+20,(y*20)+20, 20, 20);
                        g.setColor(Color.GREEN);
                        g.fillRect((x*20)+22,(y*20)+22, 16, 16);
                        if(j.getMap()[y][x].equals(j.getTeteSerpent())){
                            g.setColor(Color.BLACK);
                            g.fillOval((x*20)+27,(y*20)+26, 5, 5);
                        }
                    }
                    else if(j.getMap()[y][x] instanceof Pomme){
                        g.setColor(Color.BLACK);
                        g.fillRect((x*20)+20,(y*20)+20, 20, 20);
                        g.setColor(Color.RED);
                        g.fillOval((x*20)+24,(y*20)+24, 14, 14);
                        g.setColor(Color.PINK);
                        g.fillRect((x*20)+30,(y*20)+22, 2, 5);
                    }
                    else{
                        g.setColor(Color.BLACK);
                        g.fillRect((x*20)+20,(y*20)+20, 20, 20);
                    }
                }   
            }
    }
}
