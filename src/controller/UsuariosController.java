/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.database.DAO.UsuarioDAO;
import model.database.DAO.UsuarioDAOMySQL;
import model.database.Usuario;
import view.login.LoginJFrame;
import view.usuarios.UsuariosDialog;
import view.usuarios.añadirUsuarioDialog;

/**
 *
 * @author neira
 */
public class UsuariosController {
    private final UsuariosDialog view;
    private final UsuarioDAO usuarioDAO;
    private final LoginJFrame mainView; 

    public UsuariosController(UsuariosDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.usuarioDAO = new UsuarioDAOMySQL();
        this.view.setAddUsuarioActionListener(addUsuarioListener());
        /*this.view.setEditarUsuarioActionListener(listener);*/
        this.view.setEliminarUsuarioActionListener(eliminarUsuarioListener());
        this.view.setVolverActionListener(volverUsuariosActionListener());
        cargarUsuarios();
        
    }
    
    private void cargarUsuarios() {
        // Obtener la lista de usuarios del DAO
        ArrayList<Usuario> usuarios = usuarioDAO.mostrarUsuarios(); 
        // Mostrar los usuarios en la tabla de la vista
        view.mostrarUsuarios(usuarios);
    }
    
    private ActionListener addUsuarioListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              añadirUsuarioDialog dialog = new añadirUsuarioDialog(mainView, true);
              CrearUsuarioController cuc = new CrearUsuarioController(dialog,usuarioDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }
    
        /* TODO COMPLETAR MÉTODO PARA ELIMINAR Y VISTA CORRESPONDIENTE */
    private ActionListener eliminarUsuarioListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable tabla = view.getUsuariosTabla();
                int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el usuario seleccionado?", "Eliminar usuario", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idUsuario = (int) tabla.getValueAt(filaSeleccionada, 0);
                        System.out.println(idUsuario);
                        usuarioDAO.eliminarUsuario(idUsuario);
                        actualizarTablaUsuarios();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un usuario para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
    }
    
    public void actualizarTablaUsuarios(){
        ArrayList<Usuario> usuarios = usuarioDAO.mostrarUsuarios();
        DefaultTableModel modeloTablaUsuarios = (DefaultTableModel) view.getUsuariosTabla().getModel();
        modeloTablaUsuarios.setRowCount(0);
        for(Usuario usuario : usuarios){
            modeloTablaUsuarios.addRow(new Object[]{
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getContrasena()
            });
        }   
    }  
    
    private ActionListener volverUsuariosActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }
}
