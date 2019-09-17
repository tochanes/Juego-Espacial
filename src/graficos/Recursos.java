package graficos;

import java.awt.image.BufferedImage;

public class Recursos {
    
    public static BufferedImage jugador;
    
    public static void init(){
        jugador = Loader.cargadorImagen("/naves/player.png");
    }
}
