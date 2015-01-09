package Element;

import Element.Element;


public class Snake extends Element {
    
    private Snake boutPrecedent;
    private Snake boutSuivant;
    private int directionX;
    private int directionY;

    public Snake(int y, int x) {
        super(x, y);
        this.directionX = 0;
        this.directionY = 0;
    }
    
    public Snake(int x, int y,int directionX,int directionY) {
        super(x, y);
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }
   
    public void setPrecedent(Snake precedent){
        this.boutPrecedent = precedent;
    }
    
    public void setSuivant(Snake suivant){
        this.boutSuivant = suivant;
    }
    
    public Snake getPrecedent(){
        return this.boutPrecedent;
    }
    
    public Snake getSuivant(){
        return this.boutSuivant;
    }
    
    public boolean haut(){
        this.directionX = 0;
        if(this.directionY != 1){
            this.directionY = -1;
            return true;
        }
        return false;
    }
    
    public boolean bas(){
        this.directionX = 0;
        if(this.directionY != -1){
            this.directionY = 1;
            return true;
        }
        return false;
    }
    
    public boolean droite(){
        this.directionY = 0;
        if(this.directionX != -1){
            this.directionX = 1;
            return true;
        }
        return false;
    }
    
    public boolean gauche(){
        this.directionY = 0;
        if(this.directionX != 1){
            this.directionX = -1;
            return true;
        }
        return false;       
    }
}
