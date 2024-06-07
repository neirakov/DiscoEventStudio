/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.database.DAO.PersonalDAO;
import model.database.Personal;
import view.login.LoginJFrame;
import view.personal.PersonalDialog;
import view.personal.AñadirEmpleadoDialog;

/**
 *
 * @author neira
 */
public class AñadirEmpleadoController {
    private final AñadirEmpleadoDialog view;
    private final PersonalDAO personalDAO;
    private final LoginJFrame mainView;

    public AñadirEmpleadoController(AñadirEmpleadoDialog view, PersonalDAO personalDAO) {
        this.view = view;
        this.personalDAO = personalDAO;
        this.mainView = new LoginJFrame();
        this.view.setAñadirEmpleadoActionListener(crearEmpleadoListener());
    }
    
    private ActionListener crearEmpleadoListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empleadoNombre = view.getNombreEmpleado();
                String empleadoApellidos = view.getApellidosEmpleado();
                String empleadoDireccion = view.getDireccionEmpleado();
                String empleadoTelefono = view.getTelefonoEmpleado();
                if (empleadoNombre.isEmpty() || empleadoApellidos.isEmpty() || empleadoDireccion.isEmpty() || empleadoTelefono.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Personal empleado = new Personal(0,empleadoNombre,empleadoApellidos,empleadoDireccion,empleadoTelefono);
                personalDAO.agregarEmpleado(empleado);
                PersonalDialog psd = new PersonalDialog(mainView,true);
                PersonalController psc = new PersonalController(psd);
                view.dispose();
                psd.setVisible(true);
            }
        };
          return al;
    }
    
    
}
