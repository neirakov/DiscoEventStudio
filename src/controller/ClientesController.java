/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.database.Cliente;
import model.database.DAO.ClientesDAO;
import model.database.DAO.ClientesDAOMySQL;
import view.clientes.AddClienteDialog;
import view.clientes.ClientesDialog;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class ClientesController {
    private final ClientesDialog view;
    private final ClientesDAO clientesDAO;
    private final JFrame mainView;

    public ClientesController(ClientesDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.clientesDAO = new ClientesDAOMySQL();
        this.view.setAddClienteActionListener(addClienteListener());
        this.view.setEliminarClienteActionListener(eliminarClienteListener());
        this.view.setVolverClientesActionListener(volverClientesActionListener());
        cargarClientes();
    }
    
        private void cargarClientes() {
        ArrayList<Cliente> clientes = clientesDAO.mostrarClientes();
        view.mostrarClientes(clientes);
    }
        
        public void actualizarTablaClientes(){
        ArrayList<Cliente> clientes = clientesDAO.mostrarClientes();
        DefaultTableModel modeloTablaPersonal = (DefaultTableModel) view.getClientesTabla().getModel();
        modeloTablaPersonal.setRowCount(0);
        for(Cliente cliente : clientes){
            modeloTablaPersonal.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getCIF(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono()
            });
        }   
    }  
        
        private ActionListener addClienteListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              AddClienteDialog dialog = new AddClienteDialog(mainView, true);
              AddClienteController aec = new AddClienteController(dialog,clientesDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }    
        
        private ActionListener eliminarClienteListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable tabla = view.getClientesTabla();
                    int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Eliminar cliente", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idCliente = (int) tabla.getValueAt(filaSeleccionada, 0);
                        clientesDAO.eliminarCliente(idCliente);
                        actualizarTablaClientes();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un cliente para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
        }
        
        private ActionListener volverClientesActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }  
}
