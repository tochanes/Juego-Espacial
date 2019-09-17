
package objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Plano2D;

public class Jugador extends ObjetosJuego {
    
    public Jugador(Plano2D pocision, BufferedImage textura){
        super(pocision,textura);
    }
    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics graficos) {
        graficos.drawImage(textura,(int)pocision.getX(), (int)pocision.getY(), null);
    }
    
}
