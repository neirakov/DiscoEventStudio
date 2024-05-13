/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.usuarios.UsuariosDialog;
import view.ventanaPrincipal.VentanaPrincipalDialog;

/**
 *
 * @author neira
 */
public class VentanaPrincipalController {
    private VentanaPrincipalDialog view;

    public VentanaPrincipalController(VentanaPrincipalDialog view) {
        this.view = view;
  
    }
    
    /*private ActionListener gestionUsuariosListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuariosDialog ud = new UsuariosDialog(view,true);
                ud.setVisible(true);
            }
        };
        return al;
    }*/
    
    
    
}
