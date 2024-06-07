/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.database.DAO.MaterialDAO;
import model.database.Material;
import view.login.LoginJFrame;
import view.material.AddMaterialDialog;
import view.material.MaterialDialog;

/**
 *
 * @author neira
 */
public class AddMaterialController {
    private final AddMaterialDialog view;
    private final MaterialDAO materialDAO;
    private final LoginJFrame mainView;

    public AddMaterialController(AddMaterialDialog view, MaterialDAO materialDAO) {
        this.view = view;
        this.materialDAO = materialDAO;
        this.mainView = new LoginJFrame();
        this.view.setAñadirArticuloActionListener(crearArticuloListener());
    }
    
        private ActionListener crearArticuloListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String articuloNombre = view.getNombreArticulo();
                String unidadesDisponibles = view.getUnidadesDisponibles();
                String unidadesNoDisponibles = view.getUnidadesNoDisponibles();
                if (articuloNombre.isEmpty() || unidadesDisponibles.isEmpty() || unidadesNoDisponibles.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Material articulo = new Material(0, articuloNombre, unidadesDisponibles,unidadesNoDisponibles);
                materialDAO.agregarArticulo(articulo);
                MaterialDialog mdl = new MaterialDialog(mainView,true);
                MaterialController mcc = new MaterialController(mdl);
                view.dispose();
                mdl.setVisible(true);
            }
        };
          return al;
    }
    
    
    
}
