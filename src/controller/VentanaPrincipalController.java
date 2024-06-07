/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.login.LoginJFrame;
import view.personal.PersonalDialog;
import view.usuarios.UsuariosDialog;
import view.ventanaPrincipal.VentanaPrincipalDialog;

/**
 *
 * @author neira
 */
public class VentanaPrincipalController {
    private LoginJFrame mainFrame;
    private VentanaPrincipalDialog view;

    public VentanaPrincipalController(VentanaPrincipalDialog view,LoginJFrame mainFrame) {
        this.view = view;
        this.mainFrame= mainFrame;
        
        this.view.setGestionUsuariosActionListener(this.gestionUsuariosListener());
        this.view.setGestionPersonalActionListener(this.gestionPersonalListener());
  
    }
    
    private ActionListener gestionUsuariosListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuariosDialog ud = new UsuariosDialog(mainFrame,true);
                UsuariosController usc = new UsuariosController(ud);
                ud.setVisible(true);
                
            }
        };
        return al;
    }
    
     private ActionListener gestionPersonalListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalDialog pd = new PersonalDialog(mainFrame,true);
                PersonalController pc = new PersonalController(pd);
                pd.setVisible(true);
                
            }
        };
        return al;
    }
    
    
    
}
