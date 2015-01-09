package snoke;

import Element.*;

public class Snoke implements Jeu {
    
    private int vitesse;
    private int score;
    private Element[][] map;
    private Snake teteSerpent;
    public static int tailleMapX;
    public static int tailleMapY;
    private Pomme currentPomme;
    private boolean aJouer,pause;

    public Snoke(int x,int y){
        Snoke.tailleMapX = x;
        Snoke.tailleMapY = y;
        this.pause = true;
    }
        @Override
    public void nouvellePartie() {
        this.map = null;
        this.teteSerpent = null;
        this.currentPomme = null;
        this.score = 0;
        this.setDifficulte(Snoke.MOYEN);
        this.pause = true;
        this.initMap();
    }

    public Snake getTeteSerpent() {
        return teteSerpent;
    }
    
    private void initMap(){
        this.map = new Element[Snoke.tailleMapY][Snoke.tailleMapX];
        this.teteSerpent = new Snake((Snoke.tailleMapX/2)-1,(Snoke.tailleMapY/2));
        this.map[this.teteSerpent.getPosY()][this.teteSerpent.getPosX()] = this.teteSerpent;
        Snake bout2 = new Snake((Snoke.tailleMapX/2)-1,(Snoke.tailleMapY/2)-1);
        Snake bout3 = new Snake((Snoke.tailleMapX/2)-1,(Snoke.tailleMapY/2)-2);
        this.map[bout2.getPosY()][bout2.getPosX()] = bout2;
        this.map[bout3.getPosY()][bout3.getPosX()] = bout3;
        bout2.setSuivant(bout3);
        bout2.setPrecedent(this.teteSerpent);
        bout3.setPrecedent(bout2);
        this.teteSerpent.setSuivant(bout2);
        this.metAJour();
    }
    
    private void generePomme(){
        int tmp = 3;
        int alX = (int) (tmp + (Math.random() * (Snoke.tailleMapX - 2*tmp)));
        int alY = (int) (tmp + (Math.random() * (Snoke.tailleMapY - 2*tmp)));
        while(this.map[alY][alX] != null){
            alX = (int) (tmp + (Math.random() * (Snoke.tailleMapX - 2*tmp)));
            alY = (int) (tmp + (Math.random() * (Snoke.tailleMapY - 2*tmp)));
        }
        this.currentPomme = new Pomme(alY,alX);
        this.map[alY][alX] = this.currentPomme;
    }
    
    private void SnakeGrandit(){
        Snake newTete = new Snake(this.currentPomme.getPosX(),this.currentPomme.getPosY(),this.teteSerpent.getDirectionX(),this.teteSerpent.getDirectionY());
        this.map[newTete.getPosY()][newTete.getPosX()] = newTete;
        newTete.setSuivant(teteSerpent);
        this.teteSerpent.setPrecedent(newTete);
        this.teteSerpent = newTete;
        this.vitesse--;
    }
    
    private void SnakeAvance(){
        int tmpY = this.teteSerpent.getPosY();
        int tmpX = this.teteSerpent.getPosX();
        this.teteSerpent.setPosY(this.teteSerpent.getPosY()+this.teteSerpent.getDirectionY());
        this.teteSerpent.setPosX(this.teteSerpent.getPosX()+this.teteSerpent.getDirectionX());
        this.map[this.teteSerpent.getPosY()][this.teteSerpent.getPosX()]=this.teteSerpent;
        Snake tmp = this.teteSerpent.getSuivant();
        while(tmp!=null){
            int tmp2Y = tmp.getPosY();
            int tmp2X = tmp.getPosX();
            this.map[tmp2Y][tmp2X]=null;
            tmp.setPosX(tmpX);
            tmp.setPosY(tmpY);
            this.map[tmp.getPosY()][tmp.getPosX()]=tmp;
            tmpX = tmp2X;
            tmpY = tmp2Y;            
            tmp = tmp.getSuivant();
        }
    }
    
    @Override
    public void metAJour() {
        this.aJouer = false;
        if(this.serpentMangePomme()){
            this.SnakeGrandit();
            this.currentPomme = null;
            this.score++;
            this.vitesse--;
        }
        else{
            if(!(this.teteSerpent.getDirectionX() == 0 && this.teteSerpent.getDirectionY() == 0))
                this.SnakeAvance();
        }
        if(this.currentPomme == null)
            this.generePomme();
        try {
            Thread.sleep(this.vitesse);
        } catch (InterruptedException ex) {}
    }
       
    @Override
    public Element[][] getMap() {
        return this.map;
    }

    @Override
    public void haut() {
        if(!this.aJouer){
            if(this.teteSerpent.haut())
                this.aJouer = true;
        }
    }

    @Override
    public void bas() {
        if(!this.aJouer){
            if(this.teteSerpent.bas())
                this.aJouer = true;
        }
    }

    @Override
    public void droite() {
        if(!this.aJouer){
            if(this.teteSerpent.droite())
                this.aJouer = true;
        }
    }

    @Override
    public void gauche() {
        if(!this.aJouer){
            if(this.teteSerpent.gauche())
                this.aJouer = true;
        }
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public boolean aPerdu(){
        try{
            if( this.map[this.teteSerpent.getPosY()][this.teteSerpent.getPosX()].equals(this.teteSerpent))
                    return false;
            this.pause();
            return true;
        }catch(Exception e){}
        return true;
    }   
    
    private boolean serpentMangePomme(){
        if(this.currentPomme != null && this.currentPomme.getPosX() == this.teteSerpent.getPosX()+this.teteSerpent.getDirectionX() 
                && this.currentPomme.getPosY() == this.teteSerpent.getPosY()+this.teteSerpent.getDirectionY())
            return true;
        return false;
    }

    @Override
    public void pause() {
        this.pause = true;
    }
    
    @Override
    public void unPause(){
        this.pause = false;
    }

    @Override
    public boolean estEnPause() {
        if(this.pause)
            return true;
        return false;
    }

    @Override
    public void setDifficulte(int difficulte) {
        if(difficulte == Jeu.FACILE)
            this.vitesse = 200;
        else if(difficulte == Jeu.MOYEN)
            this.vitesse = 120;
        else if(difficulte == Jeu.DIFFICILE)
            this.vitesse = 50;
    }
}
