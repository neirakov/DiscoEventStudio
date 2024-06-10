/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.clientes.ClientesDialog;
import view.eventos.EventosDialog;
import view.furgonetas.FurgonetasDialog;
import view.login.LoginJFrame;
import view.material.MaterialDialog;
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
        this.view.setGestionMaterialActionListener(this.gestionMaterialListener());
        this.view.setGestionClientesActionListener(this.gestionClientesListener());
        this.view.setGestionFurgonetasActionListener(this.gestionFurgonetasListener());
        this.view.setGestionEventosActionListener(this.gestionEventosListener());
    }
    
    private ActionListener gestionUsuariosListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuariosDialog ud = new UsuariosDialog(mainFrame,true);
                UsuariosController usc = new UsuariosController(ud);
                ud.setVisible(true);
                ud.setLocationRelativeTo(null);
                
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
     
     private ActionListener gestionMaterialListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterialDialog md = new MaterialDialog(mainFrame,true);
                MaterialController pc = new MaterialController(md);
                md.setVisible(true);
            }
        };
        return al;
    } 
     
     private ActionListener gestionClientesListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientesDialog cd = new ClientesDialog(mainFrame,true);
                ClientesController cc = new ClientesController(cd);
                cd.setVisible(true);
            }
        };
        return al;
    } 
     
     private ActionListener gestionFurgonetasListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FurgonetasDialog fd = new FurgonetasDialog(mainFrame,true);
                FurgonetasController fc = new FurgonetasController(fd);
                fd.setVisible(true);
            }
        };
        return al;
    }
     
     private ActionListener gestionEventosListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventosDialog ed = new EventosDialog(mainFrame,true);
                EventosController fc = new EventosController(ed);
                ed.setVisible(true);
            }
        };
        return al;
    } 
     
     
}
