/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.database.DAO.UsuarioDAO;
import view.login.LoginJFrame;
import view.ventanaPrincipal.VentanaPrincipalDialog;

/**
 *
 * @author neira
 */
public class LoginController {
    private LoginJFrame view;
    private UsuarioDAO usuarioDAO;

    public LoginController(LoginJFrame view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        this.view.setInicioSesionActionListener(this.incioSesionListener());
        
    }
    
    private ActionListener incioSesionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = view.getNombreUsuario();
                String contrasena = view.getContrasena();
                boolean usuarioCorrecto = usuarioDAO.verificarCredenciales(nombreUsuario,contrasena);
                if(usuarioCorrecto){
                    VentanaPrincipalDialog vp = new VentanaPrincipalDialog(view,true);
                    vp.setVisible(true);                
                }else {
                    JOptionPane.showMessageDialog(view, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión",JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        return al;
    }  
}
