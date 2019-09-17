
package objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Plano2D;

public abstract class ObjetosJuego {
    
    protected BufferedImage textura;
    protected Plano2D pocision;
    
    public ObjetosJuego(Plano2D pocision, BufferedImage textura){
        this.pocision = pocision;
        this.textura = textura;
    }
    
    public abstract void actualizar();
    
    public abstract void dibujar(Graphics graficos); 
    
    public Plano2D getPocision(){
        return pocision;
    }
    public void setPocision(Plano2D pocision){
        this.pocision = pocision;
    }
}
