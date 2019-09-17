package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IniciarSesion extends JFrame implements ActionListener {
    Registrarse r2 = new Registrarse();
    JPanel panel;
    JButton iniciar;
    JButton registrarse ;
    JLabel etiqueta2; 
    JLabel etiqueta3;
    JTextField txtUsuario;
    JTextField txtContraseña;
    
    
    public IniciarSesion(){
        this.setSize(350, 550); //Establece el tamaño
        setTitle("Ingresar");//Titulo de la ventana
        setLocationRelativeTo(null); //Centrar la ventana
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        componentes();
        etiquetas();
        botones();
        cajasDeTexto();
    }
    
    private void componentes(){
        panel = new JPanel();//creacion de un panel
        panel.setLayout(null);
        this.getContentPane().add(panel);//agregamos el panel a la ventana
    }
     //Agregar las etiquetas al panel
    private void etiquetas(){
        JLabel etiqueta = new JLabel("INICIAR SESION");
        panel.add(etiqueta);
        etiqueta.setBounds(130, 10, 100, 40);
        
        etiqueta2 = new JLabel("Usuario");
        panel.add(etiqueta2);
        etiqueta2.setBounds(40, 50, 100, 20);
        
        etiqueta3 = new JLabel("Contraseña");
        panel.add(etiqueta3);
        etiqueta3.setBounds(40, 90, 100, 20);
    }
    
     //Agregar los botones al panel
    private void botones(){
        iniciar =  new JButton("Iniciar");
        iniciar.setBounds(40, 150, 110, 40);
        panel.add(iniciar);
        iniciar.setEnabled(true);//encendido del boton
        iniciar.addActionListener(this);
        
        registrarse = new JButton("Registrarse");
        registrarse.setBounds(180, 150, 110, 40);
        panel.add(registrarse);//encendido del boton
        registrarse.setEnabled(true);
        registrarse.addActionListener(this);
    }

    private void cajasDeTexto(){
        txtUsuario =  new JTextField();
        panel.add(txtUsuario);
        txtUsuario.setBounds(130, 50, 164, 20);
        
        txtContraseña = new JTextField();
        panel.add(txtContraseña);
        txtContraseña.setBounds(130, 90, 164, 20);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int celda = 0;
        if(e.getSource() == iniciar){
            String usuario;
            String contraseña;
            usuario = txtUsuario.getText();
            contraseña = txtContraseña.getText();
            celda = Principal.gm.getCelda(usuario, contraseña);
            
            if(celda != -1){
                JOptionPane.showMessageDialog(null, "Acceso correcto");
                Principal pp = new Principal();
                pp.start();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Acceso denegado");
            }
            
            
        }
        if(e.getSource() == registrarse){
            r2.setVisible(true);
            this.dispose();
        }
    }
    
    
    
}
