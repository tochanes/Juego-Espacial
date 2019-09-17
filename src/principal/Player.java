
package principal;

public class Player {
    private String nombre;
    private String contraseña;
    private int edad;
    private long puntaje;

    public Player(String nombre, String contraseña, int edad, long puntaje) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(long puntaje) {
        this.puntaje = puntaje;
    }
    
   
}
