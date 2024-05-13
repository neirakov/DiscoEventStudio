/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.database.DAO.UsuarioDAO;
import model.database.DAO.UsuarioDAOMySQL;
import model.database.Usuario;
import view.usuarios.UsuariosDialog;

/**
 *
 * @author neira
 */
public class UsuariosController {
    private final UsuariosDialog view;
    private final UsuarioDAO usuarioDAO;

    public UsuariosController(UsuariosDialog view, UsuarioDAO usuarioDAO) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAOMySQL();
        /*this.view.setAddUsuarioActionListener(listener);*/
        /*this.view.setEditarUsuarioActionListener(listener);*/
        /*this.view.setEliminarUsuarioActionListener(listener);*/
        /*this.view.setVolverActionListener(listener);*/
        cargarUsuarios();
    }
    
    private void cargarUsuarios() {
        // Obtener la lista de usuarios del DAO
        ArrayList<Usuario> usuarios = usuarioDAO.mostrarUsuarios();
        
        // Mostrar los usuarios en la tabla de la vista
        view.mostrarUsuarios(usuarios);
    }
    
    /* TODO COMPLETAR MÉTODO PARA AÑADIR USUARIO Y VISTA CORRESPONDIENTE
    private ActionListener addUsuarioListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
            
        }
    }
    */
    
        /* TODO COMPLETAR MÉTODO PARA AÑADIR EDITAR Y VISTA CORRESPONDIENTE
    private ActionListener editarUsuarioListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
            
        }
    }
    */
    
}
