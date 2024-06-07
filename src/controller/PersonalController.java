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
import model.database.DAO.PersonalDAO;
import model.database.DAO.PersonalDAOMySQL;
import model.database.Personal;
import model.database.Usuario;
import view.login.LoginJFrame;
import view.personal.PersonalDialog;
import view.personal.AñadirEmpleadoDialog;

/**
 *
 * @author neira
 */
public class PersonalController {
    private final PersonalDialog view;
    private final PersonalDAO personalDAO;
    private final JFrame mainView;

    public PersonalController(PersonalDialog view) {
        this.view = view;
        this.mainView = new LoginJFrame();
        this.personalDAO = new PersonalDAOMySQL();
        this.view.setAddEmpleadoActionListener(addEmpleadoListener());
        this.view.setEliminarEmpleadoActionListener(eliminarEmpleadoListener());
        this.view.setVolverPersonalActionListener(volverEmpleadosActionListener());
        cargarPersonal();
    }
    
        private void cargarPersonal() {
        // Obtener la lista de usuarios del DAO
        ArrayList<Personal> personal = personalDAO.mostrarPersonal();
        // Mostrar los usuarios en la tabla de la vista
        view.mostrarPersonal(personal);
    }
        
        public void actualizarTablaPersonal(){
        ArrayList<Personal> empleados = personalDAO.mostrarPersonal();
        DefaultTableModel modeloTablaPersonal = (DefaultTableModel) view.getPersonalTabla().getModel();
        modeloTablaPersonal.setRowCount(0);
        for(Personal empleado : empleados){
            modeloTablaPersonal.addRow(new Object[]{
                empleado.getIdEmpleado(),
                empleado.getNombre(),
                empleado.getApellidos(),
                empleado.getDireccion(),
                empleado.getTelefono()
            });
        }   
    }  
        
        private ActionListener addEmpleadoListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              AñadirEmpleadoDialog dialog = new AñadirEmpleadoDialog(mainView, true);
              AñadirEmpleadoController aec = new AñadirEmpleadoController(dialog,personalDAO);
              view.dispose();
              dialog.setLocationRelativeTo(null);
              dialog.setVisible(true);
            }   
        };
        return al;
    }    
        private ActionListener eliminarEmpleadoListener(){
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable tabla = view.getPersonalTabla();
                    int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(view, "¿Está seguro de que desea eliminar el empleado seleccionado?", "Eliminar empleado", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int idEmpleado = (int) tabla.getValueAt(filaSeleccionada, 0);
                        personalDAO.eliminarEmpleado(idEmpleado);
                        actualizarTablaPersonal();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Debe seleccionar un empleado para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        return al;
        }
        
        private ActionListener volverEmpleadosActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }
    
    
    
}
