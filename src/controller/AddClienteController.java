/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.database.Cliente;
import model.database.DAO.ClientesDAO;
import view.clientes.AddClienteDialog;
import view.clientes.ClientesDialog;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class AddClienteController {
    private final AddClienteDialog view;
    private final ClientesDAO clientesDAO;
    private final LoginJFrame mainView;

    public AddClienteController(AddClienteDialog view, ClientesDAO clientesDAO) {
        this.view = view;
        this.clientesDAO = clientesDAO;
        this.mainView = new LoginJFrame();
        this.view.setAñadirClienteActionListener(crearClienteListener());
    }
    
    private ActionListener crearClienteListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clienteNombre = view.getNombreCliente();
                String clienteCIF = view.getCifCliente();
                String clienteDireccion = view.getDireccionCliente();
                String clienteTelefono = view.getTelefonoCliente();
                if (clienteNombre.isEmpty() || clienteCIF.isEmpty() || clienteDireccion.isEmpty() || clienteTelefono.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cliente cliente = new Cliente(0,clienteNombre,clienteCIF,clienteDireccion,clienteTelefono);
                clientesDAO.agregarCliente(cliente);
                ClientesDialog cdl = new ClientesDialog(mainView,true);
                ClientesController ccc = new ClientesController(cdl);
                view.dispose();
                cdl.setVisible(true);
            }
        };
          return al;
    }
    
    
}
