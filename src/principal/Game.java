
package principal;

public class Game {
    
    Player jd[];
    int cont;
    
    public Game(){
        jd = new Player[5];
        cont = 0;
    }
    
    public int getCont(){
        return cont;
    }
    
    public int getCelda(String nombre, String contraseña){
        for(int x = 0; x < cont; x++){
         if(jd[x].getNombre().equals(nombre)){
             if(jd[x].getContraseña().equals(contraseña))
                return x;
         }
      }
        
        return -1;
    }
    
    public void agregar(String usuario, String contraseña, int edad, long puntaje){
        Player pl = new Player(usuario, contraseña, edad, puntaje);
        jd[cont] = pl;
        cont++;
    }
    
}
