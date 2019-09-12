import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Principal extends JFrame implements Runnable{
	//ANCHURA DE LA VENTANA
	public static final int WIDTH = 1080, HEIGHT = 720;
	//ATRIBUTOS
	private Canvas canvas;
	private Thread hilo;
	private boolean inicio = false;
	
	//CONTROL DE FPS
	private final int FPS = 60;
	private double contFPS = 1000000000/FPS;
	private double delta = 0;
	private int promFPS = FPS;
	
	//CONTROL GRAFICO
	private BufferStrategy buffer;
	private Graphics graficos;
	
	//ATRIBUTOS DE LA VENTANA
	public Principal() {
		setTitle("Juego Espacial");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		//REDIMENSIONAMIENTO DE LA VENTANA
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		
		add (canvas);
	}
	//METODO MAIN
	public static void main(String game[]){
		new Principal().start();
	}
	//ACTUALIZACION DE PANTALLA
	private void actualizar() {
		
	}
	//PROYECCION DE LOS SUCESOS
	private void dibujar() {
		buffer = canvas.getBufferStrategy();
		if (buffer == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		graficos = buffer.getDrawGraphics();
		//INICIO DE AREA DE DIBUJO
		
		
		
		//FIN DE AREA DE DIBUJO
		graficos.dispose();
		buffer.show();
	}
	//METODO ABSTARACTO QUE ARRANCA EL JUEGO
	@Override
	public void run() {
		
		long tiempoReal = 0;
		long ultimo = System.nanoTime();
		
		//CICLO PRINCIPAL
		while(inicio) {
			actualizar();
			dibujar();
		}
		
		finish();
	}
	private void start() {
		hilo = new Thread(this);
		hilo.start();
		inicio = true;
	}
	private void finish() {
		try {
			hilo.join();
			inicio = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
