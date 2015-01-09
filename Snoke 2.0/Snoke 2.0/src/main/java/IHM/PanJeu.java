/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import Element.Element;
import Element.Pomme;
import Element.Snake;
import java.awt.*;
import static java.awt.Color.WHITE;
import javafx.scene.layout.Border;
import javax.swing.*;
import snoke.Jeu;
import snoke.Snoke;

/**
 *
 * @author PC
 */
public class PanJeu extends JPanel {
    

 private Snoke j;
 
 public PanJeu(Snoke j){
     this.j = j;
 }

  public void paintComponent(Graphics g){
    g.setColor(WHITE);
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
