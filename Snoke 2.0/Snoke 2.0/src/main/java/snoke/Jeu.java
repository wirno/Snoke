package snoke;

import Element.Element;

public interface Jeu {
    
    public static final int FACILE = 1;
    public static final int MOYEN = 2;
    public static final int DIFFICILE = 3;
    
    
    public Element[][] getMap();
    
    public void nouvellePartie();
    
    // controle clavier
    /* Touches directionelles pour deplacer le serpent
        et s'arrete si le joueur appuie sur echap ou si il perds
    */
    public void haut();
    public void bas();
    public void droite();
    public void gauche();
    public void pause();
    public void unPause();
    
   
    public void metAJour(); //replace les objets
    /*
        FACILE = 1
        MOYEN = 2
        DIFFICILE = 3
    */
    public void setDifficulte(int difficulte);
    
    
    public int getScore();
    
    public Element getTeteSerpent();
    
    public boolean aPerdu();// condition de fin de jeu
    public boolean estEnPause();
    
    // GERRER LES SCORES ENREGISTRER ENSUITE
    
    
}
