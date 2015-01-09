/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import java.awt.Color;
import javax.swing.*;

public class PannelAffichageScore extends JPanel {
    
    public JLabel score;

    public PannelAffichageScore(){
        score = new JLabel("Score : 0");
        score.setForeground(Color.WHITE);
        this.setBackground(Color.GRAY);
        this.add(score);
    }
}
