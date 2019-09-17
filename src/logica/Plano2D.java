package logica;

public class Plano2D {
    private double x , y;
    
    public Plano2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Plano2D(){
        x = 0;
        y = 0;
    }
    
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
}
