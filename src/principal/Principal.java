
package principal;

import estados.Juego;
import graficos.Recursos;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Principal extends JFrame implements Runnable{

    public static boolean ingreso = false;
    
    public static Game gm = new Game();
    
    public static final int WIDHT = 1080, HEIGHT = 720;
    
    private Canvas lienzo = new Canvas();
    private Thread hilo;
    private boolean running = false;
    
    private BufferStrategy buffer;
    private Graphics graficos;
    
    private Juego juego;
    
    private final int FPS = 60;
    private double tiempoObjetivo = 1000000000/FPS;
    private double cambioTiempo = 0;
    private int promFPS = FPS;
    
    public Principal(){
        setTitle("Juego Espacial");
        setSize(WIDHT, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setVisible(true);
        
        lienzo.setPreferredSize(new Dimension(WIDHT, HEIGHT));
        lienzo.setMaximumSize(new Dimension(WIDHT, HEIGHT));
        lienzo.setMinimumSize(new Dimension(WIDHT, HEIGHT));
        lienzo.setFocusable(true);
        
        add(lienzo);
        
    }
    
    public static void main(String[] args) {
        
        Registrarse r2 = new Registrarse();
        IniciarSesion r1 = new IniciarSesion();
        if(gm.getCont() > 0){
            r1.setVisible(true);
            
        }else{
            r2.setVisible(true);
        }
        
    }
    

    private void actualizar(){
        juego.actualizar();
    }
    
    private void dibujar(){
        buffer = lienzo.getBufferStrategy(); 
        if(buffer == null){
            lienzo.createBufferStrategy(3);
            return;
        }
        
        graficos = buffer.getDrawGraphics();
        //Inicio de dibujo
        
        graficos.setColor(Color.BLACK);
        graficos.fillRect(0,0,WIDHT, HEIGHT);
        juego.dibujar(graficos);
        graficos.setColor(Color.CYAN);
        graficos.drawString(""+promFPS,10,20);
        
        //Fin de dibujo
        graficos.dispose();
        buffer.show();
    }
    
    private void init(){
        Recursos.init();
        juego = new Juego();
    }
    
    @Override
    public void run() {
        long now = 0;
        long horaActual = System.nanoTime();
        int frames = 0;
        long tiempo = 0;
        
        init();
        
        while(running){
            now = System.nanoTime();
            cambioTiempo += (now - horaActual)/tiempoObjetivo;
            tiempo += (now - horaActual);
            horaActual = now;
            
            if(cambioTiempo >= 1){
                actualizar();
                dibujar();
                cambioTiempo--;
                frames++;
            }
            if(tiempo >= 1000000000){
                promFPS = frames;
                frames = 0;
                tiempo = 0;
            }
        }
        
        stop();
    }

    public void start(){
        
        hilo = new Thread(this);
        hilo.start();
        running = true;
    }
    
    public void stop(){
        try {
            hilo.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                
    }
    
}
