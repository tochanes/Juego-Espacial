package estados;

import graficos.Recursos;
import java.awt.Graphics;
import logica.Plano2D;
import objetos.Jugador;

public class Juego {
    
    private Jugador jugador;
    
    public Juego(){
        jugador = new Jugador(new Plano2D(540,360), Recursos.jugador);
    }
    
    public void actualizar(){
    
    }
    
    public void dibujar(Graphics graficos){
        jugador.dibujar(graficos);
    }
}
