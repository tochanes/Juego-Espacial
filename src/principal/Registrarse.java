
package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse  extends JDialog implements ActionListener {
    
    
    JPanel panel;
    JLabel etiqueta2;
    JLabel etiqueta3;
    JLabel etiqueta4;
    JButton registrar;
    JTextField txtUsuario;
    JTextField txtContraseña;
    JTextField txtEdad;
    
    public Registrarse(){
        this.setSize(350, 550); //Establece el tamaño
        setTitle("Registrarse");//Titulo de la ventana
        setLocationRelativeTo(null); //Centrar la ventana
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        componentes();
        etiquetas();
        boton();
        cajaDeTextos();
    }
    
    public void componentes(){
        panel = new JPanel();//creacion de un panel
        panel.setLayout(null);
        this.getContentPane().add(panel);//agregamos el panel a la ventana
    }
    
    public void etiquetas(){
        JLabel etiqueta = new JLabel("Registrar nuevo usuario");
        panel.add(etiqueta);
        etiqueta.setBounds(90, 10, 200, 40);
        
        etiqueta2 = new JLabel("Usuario");
        panel.add(etiqueta2);
        etiqueta2.setBounds(40, 50, 100, 20);
        
        etiqueta3 = new JLabel("Contraseña");
        panel.add(etiqueta3);
        etiqueta3.setBounds(40, 90, 100, 20);
        
        etiqueta4 = new JLabel("Edad");
        panel.add(etiqueta4);
        etiqueta4.setBounds(40, 130, 100, 20);
    }
    
    public void cajaDeTextos(){
        txtUsuario =  new JTextField();
        panel.add(txtUsuario);
        txtUsuario.setBounds(130, 50, 164, 20);
        
        txtContraseña = new JTextField();
        panel.add(txtContraseña);
        txtContraseña.setBounds(130, 90, 164, 20);
        
        txtEdad = new JTextField();
        panel.add(txtEdad);
        txtEdad.setBounds(130, 130, 164, 20);
    }
    
    public void boton(){
        registrar = new JButton("Registrarse");
        registrar.setBounds(100, 160, 110, 40);
        panel.add(registrar);//encendido del boton
        registrar.setEnabled(true);
        registrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registrar){
            String usuario;
            String contraseña;
            int edad;
            
            usuario = txtUsuario.getText();
            contraseña = txtContraseña.getText();
            edad = Integer.parseInt(txtEdad.getText());

            int celda = Principal.gm.getCelda(usuario, contraseña);
            
            if(celda == -1){
                Principal.gm.agregar(usuario, contraseña, edad, 0);
                JOptionPane.showMessageDialog(null, "Registrado con exito");
                Principal pp = new Principal();
                pp.start();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ya existente");
            }
        }
    }
    
    
    
}
