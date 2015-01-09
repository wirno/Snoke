package Element;

import snoke.Snoke;


public class Element {
    protected int posX;
    protected int posY;
    
    public Element(int x,int y){
        this.setPosX(x);
        this.setPosY(y);
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int x) {
        if(x>=Snoke.tailleMapX)
            this.posX = 0;
        else if(x<0)
            this.posX = Snoke.tailleMapX-1;
        else
            this.posX = x;
            
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int y) {
        if(y>=Snoke.tailleMapY)
            this.posY = 0;
        else if(y<0)
            this.posY = Snoke.tailleMapY-1;
        else
            this.posY = y;
    }
    
    public String toString(){
        return "X : "+this.posX+"\nY : "+this.posY; 
    }
   
}
