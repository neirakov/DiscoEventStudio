/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.database.DAO.UsuarioDAO;
import model.database.Usuario;
import view.login.LoginJFrame;
import view.usuarios.UsuariosDialog;
import view.usuarios.AddUsuarioDialog;

/**
 *
 * @author neira
 */
public class AddUsuarioController {
    private final AddUsuarioDialog view;
    private final UsuarioDAO usuarioDAO;
    private final LoginJFrame mainView;

    public AddUsuarioController(AddUsuarioDialog view, UsuarioDAO usuarioDAO) {
        this.view = view;
        this.usuarioDAO = usuarioDAO;
        this.mainView = new LoginJFrame();
        this.view.setAddUsuarioDialogListener(crearUsuarioListener());
    }
    
    private ActionListener crearUsuarioListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioNombre = view.getUsuario();
                String contrasena = view.getContrasena();
                if (usuarioNombre.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Usuario usuario = new Usuario(0, usuarioNombre, contrasena);
                usuarioDAO.agregarUsuario(usuario);
                UsuariosDialog usd = new UsuariosDialog(mainView,true);
                UsuariosController usc = new UsuariosController(usd);
                view.dispose();
                usd.setVisible(true);
            }
        };
          return al;
    }
    
    
    
}
